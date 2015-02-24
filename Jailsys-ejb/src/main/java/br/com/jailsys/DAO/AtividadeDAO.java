package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.jailsys.model.Atividade;

@Stateless
public class AtividadeDAO extends GenericDAO<Atividade> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6730793388431922888L;

	@SuppressWarnings("unchecked")
	public List<Atividade> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Atividade a where a.ativo = true").getResultList();
	}

}
