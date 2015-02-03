package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Usuario;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.util.FacesUtil;
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
    private final String MENSAGEM_CADASTRO = "jailsysweb.usuario.cadastro.sucesso";
    private final String MENSAGEM_EDICAO = "jailsysweb.usuario.edicao.sucesso";
    private final String MENSAGEM_EXCLUSAO = "jailsysweb.usuario.exclusao.sucesso";

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
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_CADASTRO);
        this.atualizarView();
        return TELA_CONSULTA;
    }

    public void atualizarView() {
        usuarioView.setUsuarios(service.consultar());
    }

    public String editar() {
        service.editar(usuarioView.getUsuario());
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_EDICAO);
        return TELA_CONSULTA;
    }

    public String visualizar(Usuario usuario) {
        usuarioView.setUsuario(usuario);
        return TELA_EDICAO;
    }

    public String excluir(Usuario usuario) {
        service.excluir(usuario);
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_EXCLUSAO);
        return TELA_CONSULTA;
    }

    public UsuarioView getUsuarioView() {
        return usuarioView;
    }

    public void setUsuarioView(UsuarioView usuarioView) {
        this.usuarioView = usuarioView;
    }

}
