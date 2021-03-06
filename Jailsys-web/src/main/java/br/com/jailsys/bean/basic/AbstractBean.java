package br.com.jailsys.bean.basic;

import br.com.jailsys.model.EntidadeComum;

public interface AbstractBean<T extends EntidadeComum> {

	/**
	 * Carrega o botao de edicao junto com o formulario de edicao e carrega do
	 * banco os cadastros necessarios para edicao.
	 * 
	 * @return
	 */
	public String prepararEdicao();

	/**
	 * Persiste os dados da entidade correspondente no banco de dados.
	 * 
	 * @return
	 */
	public String salvar();

	/**
	 * Atualiza a lista de entidades na view
	 */
	public void atualizarView();

	/**
	 * Visualiza os dados da entidade correspondente sem permitir a edicao da
	 * mesma.
	 * 
	 * @return
	 */
	public String visualizar();

	/**
	 * Altera o status da instancia da entidade correspondente para inativo e
	 * salva no banco (exclusao logica).
	 * 
	 * @param entidade
	 * @return
	 */
	public String excluir(T entidade);

	/**
	 * Utilizado para abilitar ou desabilitar os campos do formulario
	 * 
	 * @return se o usuario se encontra na tela de visualizar
	 */
	public boolean isVisualizar();
}
