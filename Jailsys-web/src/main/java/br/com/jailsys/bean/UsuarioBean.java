package br.com.jailsys.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Usuario;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.view.UsuarioView;

@ManagedBean
@SessionScoped
public class UsuarioBean implements AbstractBean, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2256641221649626781L;

    @Inject
    private UsuarioService service;

    @Inject
    private UsuarioView usuarioView;

    private HtmlInputText inputLogin;

    private HtmlInputText inputSenha;

    private HtmlInputText inputConfimacaoSenha;

    public HtmlInputText getInputConfimacaoSenha() {
        return inputConfimacaoSenha;
    }

    public void setInputConfimacaoSenha(HtmlInputText inputConfimacaoSenha) {
        this.inputConfimacaoSenha = inputConfimacaoSenha;
    }
    
    public void teste() {
        System.out.println("asdas");
    }

    private HtmlCommandButton botaoSalvar;

    public String consultar() {
        if (usuarioView.getUsuarios().isEmpty()) {
            usuarioView.setUsuarios(service.consultar());
        }
        return "usuarioConsulta";
    }

    public String prepararInclusao(ActionEvent actionEvent) {
        return "usuarioCadastro";
    }

    public String prepararEdicao(Usuario usuario) {
        usuarioView.setUsuario(usuario);
        return "usuarioEdicao";
    }

    public String salvar() {
        service.salvar(usuarioView.getUsuario());
        addMessage("Usuário Cadastrado com sucesso");
        usuarioView.setUsuarios(service.consultar());
        return "usuarioConsulta.xhtml?faces-redirect=true";
    }

    public String editar(ActionEvent actionEvent) {
        service.editar(usuarioView.getUsuario());
        addMessage("Usuário Editado com sucesso");
        return "usuarioConsulta";
    }

    public String visualizar(Usuario usuario) {
        usuarioView.setUsuario(usuario);
        this.inputLogin.setDisabled(true);
        this.inputSenha.setDisabled(true);
        this.botaoSalvar.setDisabled(true);
        return "usuarioCadastro.xhtml?faces-redirect=true";
    }

    public String excluir(Usuario usuario) {
        service.excluir(usuario);
        addMessage("Usuário Excluido com sucesso");
        return "usuarioConsulta";
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

    public HtmlInputText getInputLogin() {
        return inputLogin;
    }

    public void setInputLogin(HtmlInputText inputLogin) {
        this.inputLogin = inputLogin;
    }

    public HtmlInputText getInputSenha() {
        return inputSenha;
    }

    public void setInputSenha(HtmlInputText inputSenha) {
        this.inputSenha = inputSenha;
    }

    public HtmlCommandButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public void setBotaoSalvar(HtmlCommandButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

}
