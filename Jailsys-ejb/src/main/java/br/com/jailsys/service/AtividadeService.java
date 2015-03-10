package br.com.jailsys.service;

import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.AtividadeDAO;
import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;

public class AtividadeService implements AbstractService<EntidadeComum> {

	@Inject
	AtividadeDAO atividadeDAO;

	public List<Atividade> listar() {
		return atividadeDAO.listar();
	}

	public List<Atividade> listarItensAtivos() {
		return atividadeDAO.listarItensAtivos();
	}

	public List<Atividade> listarDesvinculadas(Long idAmbiente) {
		return atividadeDAO.listarDesvinculadas(idAmbiente.toString());
	}
	
	public List<Atividade> listarVinculadas(Long idAmbiente) {
		return atividadeDAO.listarVinculadas(idAmbiente.toString());
	}
	
	@Override
	public void salvar(EntidadeComum entidade) {
		atividadeDAO.salvar((Atividade) entidade);

	}

	@Override
	public EntidadeComum salvarERetornar(EntidadeComum entidade) {
		return atividadeDAO.salvarERetornar((Atividade) entidade);
	}

	@Override
	public void editar(EntidadeComum entidade) {
		atividadeDAO.editar((Atividade) entidade);
	}

	@Override
	public void excluir(Long id) {
		Atividade atividade = atividadeDAO.buscar(id);
		excluir(atividade);
	}

	@Override
	public void excluir(EntidadeComum entidade) {
		Atividade atividade = (Atividade) entidade;
		atividade.setAtivo(Boolean.FALSE);
		for(Ambiente ambiente : atividade.getAmbientes()){
			atividadeDAO.excluirRelacionamentoAtividadeAmbiente(ambiente.getId(), atividade);
		}
		
		atividadeDAO.editar(atividade);
	}

	@Override
	public EntidadeComum buscar(Long id) {
		return atividadeDAO.buscar(id);
	}

}
