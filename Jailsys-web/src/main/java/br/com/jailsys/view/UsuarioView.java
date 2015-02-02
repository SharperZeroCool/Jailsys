package br.com.jailsys.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jailsys.model.Usuario;

@Named
public class UsuarioView implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 693074166910643443L;

    @Inject
    Usuario usuario;

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    private String confirmacaoSenha;

    private HtmlInputText inputLogin;

    private HtmlInputText inputSenha;

    private HtmlInputText inputConfimacaoSenha;

    private HtmlCommandButton botaoSalvar;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
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

    public HtmlInputText getInputConfimacaoSenha() {
        return inputConfimacaoSenha;
    }

    public void setInputConfimacaoSenha(HtmlInputText inputConfimacaoSenha) {
        this.inputConfimacaoSenha = inputConfimacaoSenha;
    }

    public HtmlCommandButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public void setBotaoSalvar(HtmlCommandButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }
}
