package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.jailsys.model.Ambiente;

@Stateless
public class AmbienteDAO extends GenericDAO<Ambiente> implements Serializable {

	private static final long serialVersionUID = 5343361632900144662L;

	@SuppressWarnings("unchecked")
	public List<Ambiente> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Ambiente a where a.ativo = true").getResultList();
	}
}
