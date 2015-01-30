package br.com.jailsys.bean.basic;

import javax.faces.event.ActionEvent;

public interface AbstractBean {

    /**
     * Carrega a tela de Consulta, listando todos os cadastros
     * @param actionEvent
     * @return
     */
    public String consultar(ActionEvent actionEvent);
    
    /**
     * Carrega o botao de inclusao junto com o formulario de cadastro e carrega do banco os cadastros necessarios para inclusao
     * @param actionEvent
     * @return
     */
    public String prepararInclusao(ActionEvent actionEvent);
    
    /**
     * Carrega o botao de edicao junto com o formulario de edicao e carrega do banco os cadastros necessarios para edicao
     * @param actionEvent
     * @return
     */
    public String prepararEdicao(ActionEvent actionEvent);

    
    /**
     * Persiste os dados do cadastro no banco de dados
     * @param actionEvent
     * @return
     */
    public String salvar(ActionEvent actionEvent);

    /**
     * Altera os dados da entidade correspondente no banco de dados
     * @param actionEvent
     * @return
     */
    public String editar(ActionEvent actionEvent);

    public String visualizar(ActionEvent actionEvent);

    public String excluir(ActionEvent actionEvent);
}
