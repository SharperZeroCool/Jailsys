package br.com.jailsys.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.view.UsuarioView;

@ManagedBean
public class UsuarioBean implements AbstractBean {

    @Inject
    private UsuarioView usuarioView;

    public UsuarioView getUsuarioView() {
        return usuarioView;
    }

    public void setUsuarioView(UsuarioView usuarioView) {
        this.usuarioView = usuarioView;
    }

    public String consultar(ActionEvent actionEvent) {
        return "usuarioConsulta";
    }

    public String salvar(ActionEvent actionEvent) {
        addMessage("Usuário Cadastrado com sucesso");
        return "usuarioConsulta";
    }

    public String editar(ActionEvent actionEvent) {
        return "usuarioCadastro";
    }

    public String visualizar(ActionEvent actionEvent) {
        return "usuarioCadastro";
    }

    public String excluir(ActionEvent actionEvent) {
        return "usuarioConsulta";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    @Override
    public String prepararInclusao(ActionEvent actionEvent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String prepararEdicao(ActionEvent actionEvent) {
        // TODO Auto-generated method stub
        return null;
    }

}
