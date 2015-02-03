package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Usuario;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.view.UsuarioView;

@ManagedBean
@ViewScoped
public class UsuarioBean implements AbstractBean, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2256641221649626781L;

    @Inject
    private UsuarioService service;

    @Inject
    private UsuarioView usuarioView;

    private final String TELA_CADASTRO = "usuarioCadastro.xhtml";
    private final String TELA_CONSULTA = "usuarioConsulta.xhtml";
    private final String TELA_EDICAO = "usuarioEdicao.xhtml";
    private final String MUDAR_URL = "?faces-redirect=true";

    public List<Usuario> consultar() {
        if (usuarioView.getUsuarios().isEmpty()) {
            usuarioView.setUsuarios(service.consultar());
        }
        return usuarioView.getUsuarios();
    }

    public String prepararInclusao(ActionEvent actionEvent) {
        return TELA_CADASTRO;
    }

    public String prepararEdicao(Usuario usuario) {
        usuarioView.setUsuario(usuario);
        return TELA_EDICAO;
    }

    public String salvar() {
        service.salvar(usuarioView.getUsuario());
        addMessage("Usuário Cadastrado com sucesso");
        this.atualizarView();
        return TELA_CONSULTA + MUDAR_URL;
    }

    public void atualizarView() {
        usuarioView.setUsuarios(service.consultar());
    }

    public String editar() {
        service.editar(usuarioView.getUsuario());
        addMessage("Usuário Editado com sucesso");
        return TELA_CONSULTA + MUDAR_URL;
    }

    public String visualizar(Usuario usuario) {
        usuarioView.setUsuario(usuario);
        return TELA_EDICAO;
    }

    public String excluir(Usuario usuario) {
        service.excluir(usuario);
        addMessage("Usuário Excluído com sucesso");
        return TELA_CONSULTA;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public UsuarioView getUsuarioView() {
        return usuarioView;
    }

    public void setUsuarioView(UsuarioView usuarioView) {
        this.usuarioView = usuarioView;
    }

}
