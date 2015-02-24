package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.jailsys.model.Grupo;
import br.com.jailsys.model.Usuario;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario> implements Serializable {

	private static final long serialVersionUID = -8005124363338809772L;

	@Inject
	GrupoDAO grupoDao;

	public void salvar(Usuario entidade) {
		getEntityManager().merge(entidade);
		getEntityManager().flush();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarItensAtivos() {
		return getEntityManager().createQuery(
				"FROM Usuario u WHERE u.ativo = true").getResultList();
	}

	public List<Grupo> listarGrupos() {
		return grupoDao.listar();
	}
}
