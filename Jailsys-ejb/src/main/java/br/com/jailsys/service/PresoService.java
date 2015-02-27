package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.PresoDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.model.Preso;

public class PresoService implements AbstractService<EntidadeComum>,
		Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 8243931725677708911L;
	@Inject
	PresoDAO presoDao;

	@Override
	public void salvar(EntidadeComum entidade) {
		Preso preso = (Preso) entidade;
		presoDao.salvar(preso);
	}

	
	@Override
	public EntidadeComum salvarERetornar(EntidadeComum entidade) {
		return presoDao.salvarERetornar((Preso) entidade);
	}

	@Override
	public void editar(EntidadeComum entidade) {
		presoDao.editar((Preso) entidade);
	}

	@Override
	public void excluir(Long id) {
		Preso preso = (Preso) buscar(id);
		excluir(preso);
	}

	@Override
	public void excluir(EntidadeComum entidade) {
		((Pessoa) entidade).setAtivo(Boolean.FALSE);
		presoDao.editar((Preso) entidade);
	}

	@Override
	public EntidadeComum buscar(Long id) {
		return presoDao.buscar(id);
	}

	public List<Preso> listar() {
		return presoDao.listarAtivo();
	}

	public List<Preso> listarItensAtivos() {
		return presoDao.listarItensAtivos();
	}

}
