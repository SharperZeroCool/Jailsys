package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.UsuarioDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Grupo;
import br.com.jailsys.model.Usuario;
import br.com.jailsys.util.CriptografiaUtil;

public class UsuarioService implements AbstractService<EntidadeComum>,
		Serializable {

	private static final long serialVersionUID = 1028924301178170070L;
	@Inject
	UsuarioDAO usuarioDao;

	private final String LOGIN = "login";

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
		usuarioDao.excluir((Usuario) entidade);
	}

	@Override
	public EntidadeComum buscar(Long id) {
		return usuarioDao.buscar(id);
	}

	public Usuario buscarPorLogin(String login) {
		return usuarioDao.buscarPor(LOGIN, login);
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

	public boolean isSenhaCorreta(Usuario usuario, String senhaAtual) {
		Usuario usuarioAntigo = (Usuario) buscar(usuario.getId());
		return usuarioAntigo.getSenha().equals(
				CriptografiaUtil.criptografar(senhaAtual));
	}

}
