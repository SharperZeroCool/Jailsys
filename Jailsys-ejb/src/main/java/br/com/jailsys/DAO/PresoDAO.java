package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import br.com.jailsys.model.Crime;
import br.com.jailsys.model.Preso;

@Stateless
@SuppressWarnings("unchecked")
public class PresoDAO extends GenericDAO<Preso> implements Serializable {

	private static final long serialVersionUID = -5038738004256802472L;

	@Inject
	private CrimeDAO crimeDao;

	public Preso buscar(Long id) {
		Query query = getEntityManager()
				.createQuery(
						"select distinct p from Preso p LEFT JOIN FETCH p.crimes LEFT JOIN FETCH p.atividades where p.id = :id");
		query.setParameter("id", id);
		return (Preso) query.getSingleResult();
	}

	public List<Preso> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Preso p WHERE p.ativo = true").getResultList();
	}

	public List<Crime> listarCrimes() {
		return crimeDao.listar();
	}

	public List<Crime> listarCrimesDesvinculados(Long presoId) {
		Query query = getEntityManager()
				.createQuery(
						"SELECT c FROM Crime c WHERE c.id NOT IN (SELECT c.id FROM Preso p JOIN p.crimes c WHERE p.id = :valor)");
		query.setParameter("valor", presoId);
		return query.getResultList();
	}

	public List<Crime> listarCrimesVinculados(Long presoId) {
		Query query = getEntityManager().createQuery(
				"SELECT c FROM Preso p JOIN p.crimes c WHERE p.id = :valor");
		query.setParameter("valor", presoId);
		return query.getResultList();
	}

}
