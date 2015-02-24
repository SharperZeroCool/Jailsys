package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.PessoaDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;

public class PessoaService implements AbstractService<EntidadeComum>,
		Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 6623540764664272252L;

	@Inject
	PessoaDAO pessoaDao;

	@Override
	public void salvar(EntidadeComum entidade) {
		pessoaDao.salvar((Pessoa) entidade);
	}

	@Override
	public EntidadeComum salvarERetornar(EntidadeComum entidade) {
		pessoaDao.salvarERetornar((Pessoa) entidade);
		return (Pessoa) entidade;
	}

	@Override
	public void editar(EntidadeComum entidade) {
		pessoaDao.editar((Pessoa) entidade);
	}

	@Override
	public void excluir(Long id) {
		Pessoa pessoa = pessoaDao.buscar(id);
		excluir(pessoa);
	}

	@Override
	public void excluir(EntidadeComum entidade) {
		((Pessoa) entidade).setAtivo(Boolean.FALSE);
		pessoaDao.editar((Pessoa) entidade);
	}

	@Override
	public EntidadeComum buscar(Long id) {
		return pessoaDao.buscar(id);
	}

	public List<Pessoa> listar() {
		return pessoaDao.listar();
	}

	public List<Pessoa> listarItensAtivos() {
		return pessoaDao.listarItensAtivos();
	}

}
