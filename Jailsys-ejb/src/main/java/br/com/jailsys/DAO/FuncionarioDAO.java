package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.jailsys.model.Funcionario;

@Stateless
public class FuncionarioDAO extends GenericDAO<Funcionario> implements
		Serializable {

	private static final long serialVersionUID = -3325896059017717362L;

	public Funcionario buscar(Long id) {
		Query query = getEntityManager()
				.createQuery(
						"select distinct f from Funcionario f LEFT JOIN FETCH f.atividades where f.id = :id");
		query.setParameter("id", id);
		return (Funcionario) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Funcionario o WHERE o.ativo = true").getResultList();
	}

}
