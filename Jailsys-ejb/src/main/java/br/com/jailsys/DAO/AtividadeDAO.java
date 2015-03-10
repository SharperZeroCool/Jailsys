package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.Atividade;

@Stateless
@SuppressWarnings("unchecked")
public class AtividadeDAO extends GenericDAO<Atividade> implements Serializable {

	private static final long serialVersionUID = -6730793388431922888L;

	@Inject
	AmbienteDAO ambienteDao;

	public List<Atividade> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Atividade a WHERE a.ativo = true").getResultList();
	}

	public List<Atividade> listarDesvinculadas(String idAmbiente) {
		return getEntityManager()
				.createQuery(
						"SELECT a FROM Atividade a WHERE ((a.ativo = true) AND (a.id NOT IN(SELECT a2.id FROM Ambiente amb2 JOIN amb2.atividades a2 WHERE amb2.id ="
								+ idAmbiente + ")))").getResultList();
	}

	public List<Atividade> listarVinculadas(String idAmbiente) {
		return getEntityManager().createQuery(
				"SELECT a FROM Ambiente amb JOIN amb.atividades a WHERE amb.id ="
						+ idAmbiente + ")").getResultList();
	}

	public void excluirRelacionamentoAtividadeAmbiente(Long idAmbiente,
			Atividade atividade) {
		Ambiente ambiente = ambienteDao.buscar(idAmbiente);
		ambiente.getAtividades().remove(atividade);
		getEntityManager().flush();
	}

}
