package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.UsuarioDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Grupo;
import br.com.jailsys.model.Usuario;

public class UsuarioService implements AbstractService<EntidadeComum>,
		Serializable {

	private static final long serialVersionUID = 1028924301178170070L;
	@Inject
	UsuarioDAO usuarioDao;

	@Override
	public void salvar(EntidadeComum entidade) {
		((Usuario) entidade).criptografarSenha();
		usuarioDao.salvar((Usuario) entidade);
	}

	@Override
	public EntidadeComum salvarERetornar(EntidadeComum entidade) {
		return usuarioDao.salvarERetornar((Usuario) entidade);
	}

	@Override
	public void editar(EntidadeComum entidade) {
		usuarioDao.editar((Usuario) entidade);
	}

	@Override
	public void excluir(Long id) {
		Usuario usuario = (Usuario) buscar(id);
		excluir(usuario);
	}

	@Override
	public void excluir(EntidadeComum entidade) {
		((Usuario) entidade).setAtivo(Boolean.FALSE);
		usuarioDao.editar((Usuario) entidade);
	}

	@Override
	public EntidadeComum buscar(Long id) {
		return usuarioDao.buscar(id);
	}

	public List<Usuario> listar() {
		return usuarioDao.listar();
	}

	public List<Usuario> listarItensAtivos() {
		return usuarioDao.listarItensAtivos();
	}

	public List<Grupo> listarGrupos() {
		return usuarioDao.listarGrupos();
	}

}
