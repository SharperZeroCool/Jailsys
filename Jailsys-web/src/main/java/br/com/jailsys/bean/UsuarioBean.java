package br.com.jailsys.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.view.UsuarioView;

@ManagedBean
public class UsuarioBean implements AbstractBean {
    
    @Inject
    private UsuarioService service;

    @Inject
    private UsuarioView usuarioView;

    public UsuarioView getUsuarioView() {
        return usuarioView;
    }

    public void setUsuarioView(UsuarioView usuarioView) {
        this.usuarioView = usuarioView;
    }

    public String consultar(ActionEvent actionEvent) {
        service.consultar();
        return "usuarioConsulta";
    }

    public String prepararInclusao(ActionEvent actionEvent) {
        return "usuarioCadastro";
    }

    public String prepararEdicao(ActionEvent actionEvent) {
        service.buscar(null);
        return "usuarioCadastro";
    }

    public String salvar(ActionEvent actionEvent) {
        service.salvar(usuarioView.getUsuario());
        addMessage("Usuário Cadastrado com sucesso");
        return "usuarioConsulta";
    }

    public String editar(ActionEvent actionEvent) {
        service.editar(usuarioView.getUsuario());
        return "usuarioCadastro";
    }

    public String visualizar(ActionEvent actionEvent) {
        service.buscar(null);
        return "usuarioCadastro";
    }

    public String excluir(ActionEvent actionEvent) {
        service.excluir(usuarioView.getUsuario());
        return "usuarioConsulta";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
