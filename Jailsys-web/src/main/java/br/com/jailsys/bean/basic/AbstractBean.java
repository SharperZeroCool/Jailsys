package br.com.jailsys.bean.basic;

import java.util.List;

import javax.faces.event.ActionEvent;

import br.com.jailsys.model.Usuario;

public interface AbstractBean {

    /**
     * Carrega a tela de Consulta, listando todos os cadastros.
     * 
     * @param actionEvent
     * @return
     */
    public List<Usuario> consultar();

    /**
     * Carrega o botao de inclusao junto com o formulario de cadastro e carrega
     * do banco os cadastros necessarios para inclusao.
     * 
     * @param actionEvent
     * @return
     */
    public String prepararInclusao(ActionEvent actionEvent);

    /**
     * Carrega o botao de edicao junto com o formulario de edicao e carrega do
     * banco os cadastros necessarios para edicao.
     * 
     * @param actionEvent
     * @return
     */
    public String prepararEdicao(Usuario usuario);

    /**
     * Persiste os dados da entidade correspondente no banco de dados.
     * 
     * @param actionEvent
     * @return
     */
    public String salvar();

    /**
     * Altera os dados da entidade correspondente no banco de dados.
     * 
     * @param actionEvent
     * @return
     */
    public String editar(ActionEvent actionEvent);

    /**
     * Visualiza os dados da entidade correspondente sem permitir a edicao da
     * mesma.
     * 
     * @param actionEvent
     * @return
     */
    public String visualizar(Usuario usuario);

    /**
     * Altera o status da instancia da entidade correspondente para inativo e
     * salva no banco (exclusao logica).
     * 
     * @param actionEvent
     * @return
     */
    public String excluir(Usuario usuario);
}
