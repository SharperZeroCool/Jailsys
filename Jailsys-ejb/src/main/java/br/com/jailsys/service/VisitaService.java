package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.VisitaDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Visita;

public class VisitaService implements AbstractService<EntidadeComum>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2872864387633147692L;
	
	@Inject
	private VisitaDAO visitaDao;
	
	public List<Visita> listarVisitas(){
		return visitaDao.listar();
	}

	@Override
	public void salvar(EntidadeComum entidade) {
		visitaDao.salvar((Visita) entidade);
	}

	@Override
	public EntidadeComum salvarERetornar(EntidadeComum entidade) {
		return visitaDao.salvarERetornar((Visita) entidade);
	}

	@Override
	public void editar(EntidadeComum entidade) {
		visitaDao.editar((Visita) entidade);
	}

	@Override
	public void excluir(Long id) {
		visitaDao.excluir(id);
	}

	@Override
	public void excluir(EntidadeComum entidade) {
		visitaDao.excluir((Visita) entidade);
	}

	@Override
	public EntidadeComum buscar(Long id) {
		return visitaDao.buscar(id);
	}

}
