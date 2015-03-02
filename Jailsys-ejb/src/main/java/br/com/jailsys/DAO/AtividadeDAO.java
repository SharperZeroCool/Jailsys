package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.jailsys.model.Atividade;

@Stateless
@SuppressWarnings("unchecked")
public class AtividadeDAO extends GenericDAO<Atividade> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6730793388431922888L;

	public List<Atividade> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Atividade a WHERE a.ativo = true").getResultList();
	}

	public List<Atividade> listarDesvinculadas(String idAtividade) {
				/*"SELECT * FROM atividade a WHERE ((a.ativo = true) AND (a.id NOT IN (SELECT aa.idAtividade FROM atividadeambiente aa WHERE aa.idAmbiente = 9)));";*/
		/*getEntityManager().createQuery(
				"SELECT a FROM Atividade a WHERE ((a.ativo = true) AND (a.id NOT IN(SELECT a2.id FROM Ambiente amb2 JOIN amb2.atividades a2 WHERE amb2.id ="+ idAtividade +")))"
				).getResultList();*/
		return getEntityManager().createQuery(
				"SELECT a FROM Atividade a WHERE ((a.ativo = true) AND (a.id NOT IN(SELECT a2.id FROM Ambiente amb2 JOIN amb2.atividades a2)))"
				).getResultList();
	}
	
	public List<Atividade> listarVinculadas(String idAtividade) {
		/*getEntityManager().createQuery(
				"SELECT a FROM Ambiente amb JOIN amb.atividades a WHERE amb.id ="+ idAtividade +")"
				).getResultList();*/
		return getEntityManager().createQuery(
				"SELECT a FROM Ambiente amb JOIN amb.atividades a)"
				).getResultList();
	}
	

}
