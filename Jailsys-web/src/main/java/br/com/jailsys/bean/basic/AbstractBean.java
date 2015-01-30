package br.com.jailsys.bean.basic;

import javax.faces.event.ActionEvent;

public interface AbstractBean {

    public String consultar(ActionEvent actionEvent);
    
    public String prepararInclusao(ActionEvent actionEvent);
    
    public String prepararEdicao(ActionEvent actionEvent);

    public String salvar(ActionEvent actionEvent);

    public String editar(ActionEvent actionEvent);

    public String visualizar(ActionEvent actionEvent);

    public String excluir(ActionEvent actionEvent);
}
