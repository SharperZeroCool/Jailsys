package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.jailsys.model.Pessoa;

@Stateless
public class PessoaDAO extends GenericDAO<Pessoa> implements Serializable {

	private static final long serialVersionUID = -7750379895631731135L;

	public Pessoa buscar(Long id) {
		Query query = getEntityManager()
				.createQuery(
						"select distinct p from Pessoa p LEFT JOIN FETCH p.atividades where p.id = :id");
		query.setParameter("id", id);
		return (Pessoa) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Pessoa o WHERE o.ativo = true").getResultList();
	}

}
