package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;

@Stateless
@SuppressWarnings("unchecked")
public class AtividadeDAO extends GenericDAO<Atividade> implements Serializable {

	private static final long serialVersionUID = -6730793388431922888L;

	@Inject
	AmbienteDAO ambienteDao;

	@Inject
	PessoaDAO pessoaDao;

	public List<Atividade> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Atividade a WHERE a.ativo = true").getResultList();
	}

	public List<Atividade> listarDesvinculadas(EntidadeComum entidade) {
		Query query = getEntityManager()
				.createQuery(
						"SELECT a FROM Atividade a WHERE ((a.ativo = true) AND (a.id NOT IN(SELECT a2.id FROM "
								+ entidade.getClass().getSimpleName()
								+ " ent JOIN ent.atividades a2 WHERE ent.id =:id)))");
		query.setParameter("id", entidade.getId());
		return query.getResultList();
	}

	public void excluirRelacionamentoAtividadeAmbiente(Long idAmbiente,
			Atividade atividade) {
		Ambiente ambiente = ambienteDao.buscar(idAmbiente);
		ambiente.getAtividades().remove(atividade);
		getEntityManager().flush();
	}

	public void excluirRelacionamentoAtividadePessoa(Long idPessoa,
			Atividade atividade) {
		Pessoa pessoa = pessoaDao.buscar(idPessoa);
		pessoa.getAtividades().remove(atividade);
		getEntityManager().flush();
	}

}
