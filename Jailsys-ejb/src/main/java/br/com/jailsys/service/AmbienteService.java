package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.AmbienteDAO;
import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.EntidadeComum;

public class AmbienteService implements AbstractService<EntidadeComum>,
		Serializable {

	private static final long serialVersionUID = -4724998597875963171L;

	@Inject
	AmbienteDAO ambienteDao;

	public List<Ambiente> listar() {
		return ambienteDao.listar();
	}

	public List<Ambiente> listarItensAtivos() {
		return ambienteDao.listarItensAtivos();
	}

	@Override
	public void salvar(EntidadeComum entidade) {
		ambienteDao.salvar((Ambiente) entidade);
	}

	@Override
	public EntidadeComum salvarERetornar(EntidadeComum entidade) {
		ambienteDao.salvarERetornar((Ambiente) entidade);
		return (Ambiente) entidade;
	}

	@Override
	public void editar(EntidadeComum entidade) {
		ambienteDao.editar((Ambiente) entidade);

	}

	@Override
	public void excluir(Long id) {
		Ambiente ambiente = ambienteDao.buscar(id);
		excluir(ambiente);
	}

	@Override
	public void excluir(EntidadeComum entidade) {
		((Ambiente) entidade).setAtivo(Boolean.FALSE);
		((Ambiente) entidade).setAtividades(null);
		ambienteDao.editar((Ambiente) entidade);
	}

	@Override
	public EntidadeComum buscar(Long id) {
		return ambienteDao.buscar(id);
	}

}
