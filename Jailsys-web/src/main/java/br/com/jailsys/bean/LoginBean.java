package br.com.jailsys.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;

import org.jboss.logging.Logger;

import br.com.jailsys.model.Usuario;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.util.UtilitarioSeguranca;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 3638971658681340201L;

	private static final Logger LOGGER = Logger.getLogger(LoginBean.class);

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario;

	public LoginBean() {
		usuario = new Usuario();
	}

	public void acessarSistema() {
		try {
			login();
		} catch (ServletException e) {
			FacesUtil
					.mostrarMensagemErro("jailsysweb.erro.mensagem.usuario.senha.invalidos");
			LOGGER.error(
					FacesUtil
							.getMessage("jailsysweb.erro.mensagem.usuario.senha.invalidos"),
					e);
		}
		String retorno = FacesUtil.getServletRequest().getHeader("Referer");
		if (encalinhaPaginaSolicitada(retorno)) {
			redirecionar(retorno);
		} else {
			redirecionar(FacesUtil.gerarUrl("/index.xhtml?faces-redirect=true"));
		}
	}

	public boolean encalinhaPaginaSolicitada(String retorno) {
		return retorno.contains("/") && (!retorno.contains("login.xhtml"));
	}

	public String sair() {
		UtilitarioSeguranca.logout();
		return "/index.xhtml?faces-redirect=true";
	}

	public boolean estaLogado() {
		return UtilitarioSeguranca.estaLogado();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private void login() throws ServletException {
		UtilitarioSeguranca.logout();
		UtilitarioSeguranca.login(usuario);
		usuario = obterUsuarioLogado();
	}

	private Usuario obterUsuarioLogado() {
		return usuarioService.buscarPorLogin(UtilitarioSeguranca
				.getUsuarioLogado());
	}

	private void redirecionar(String retorno) {
		try {
			FacesUtil.getExternalContext().getFlash().setKeepMessages(true);
			FacesUtil.redirect(retorno);
		} catch (IOException e) {
			FacesUtil
					.mostrarMensagemErro("jailsysweb.erro.mensagem.efetuar.login");
			LOGGER.error(FacesUtil
					.getMessage("jailsysweb.erro.mensagem.efetuar.login"), e);
		}
	}
}
