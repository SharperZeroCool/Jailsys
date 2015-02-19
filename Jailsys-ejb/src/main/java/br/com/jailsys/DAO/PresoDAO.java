package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.jailsys.model.Preso;

@Stateless
@SuppressWarnings("unchecked")
public class PresoDAO extends GenericDAO<Preso> implements Serializable {

	private static final long serialVersionUID = -5038738004256802472L;

	public List<Preso> listarAtivo() {
		return getEntityManager()
				.createQuery("FROM Preso p Where p.ativo=true").getResultList();
	}

	public List<Preso> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Preso p WHERE p.ativo = true").getResultList();
	}

}
