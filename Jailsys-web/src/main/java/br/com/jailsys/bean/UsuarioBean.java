package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Grupo;
import br.com.jailsys.model.Usuario;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.UsuarioView;

@ManagedBean
@ViewScoped
public class UsuarioBean implements AbstractBean<EntidadeComum>, Serializable {

	private static final long serialVersionUID = 2256641221649626781L;

	@Inject
	private UsuarioService service;

	@Inject
	private UsuarioView usuarioView;

	public List<Usuario> listar() {
		if (usuarioView.getUsuarios().isEmpty()) {
			this.atualizarView();
		}
		return usuarioView.getUsuarios();
	}

	public List<Usuario> listarItensAtivos() {
		if (usuarioView.getUsuarios().isEmpty()) {
			this.atualizarView();
		}
		return usuarioView.getUsuarios();
	}

	public List<Grupo> listarGrupos() {
		return service.listarGrupos();
	}

	@Override
	public String salvar() {
		Usuario usuario = usuarioView.getUsuario();
		service.salvar(usuario);
		usuario.enviarEmailCriacao();
		FacesUtil.mostrarMensagemSucesso(Constantes.Usuario.MENSAGEM_CADASTRO);
		this.atualizarView();
		return Constantes.Usuario.TELA_CONSULTA;
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Usuario.TELA_EDICAO;
	}

	@Override
	public void atualizarView() {
		usuarioView.setUsuarios(service.listarItensAtivos());
	}

	public String editar() {
		Usuario usuario = usuarioView.getUsuario();
		if (service.isSenhaCorreta(usuario, usuarioView.getSenhaAtual())) {
			service.editar(usuario);
			usuario.enviarEmailEdicao();
			FacesUtil
					.mostrarMensagemSucesso(Constantes.Usuario.MENSAGEM_EDICAO);
			return Constantes.Usuario.TELA_CONSULTA;
		} else {
			FacesUtil
					.mostrarMensagemSucesso(Constantes.Usuario.MENSAGEM_ERROR_EDICAO);
			return null;
		}
	}

	@Override
	public String visualizar() {
		return Constantes.Usuario.TELA_VISUALIZAR;
	}

	@Override
	public String excluir(EntidadeComum entidadeComum) {
		Usuario usuario = (Usuario) entidadeComum;
		service.excluir(usuario);
		usuario.enviarEmailExclusao();
		FacesUtil.mostrarMensagemSucesso(Constantes.Usuario.MENSAGEM_EXCLUSAO);
		return Constantes.Usuario.TELA_CONSULTA;
	}

	@Override
	public boolean isVisualizar() {
		return Boolean.parseBoolean(FacesUtil
				.getRequestParameter("isVisualizar"));
	}

	public boolean isCadastrar() {
		return usuarioView.getUsuario().getId() == null;
	}

	public UsuarioView getUsuarioView() {
		return usuarioView;
	}

	public void setUsuarioView(UsuarioView usuarioView) {
		this.usuarioView = usuarioView;
	}

}