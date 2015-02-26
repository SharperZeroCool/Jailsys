package br.com.jailsys.util;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import br.com.jailsys.model.Usuario;

import com.google.common.base.Preconditions;

public final class UtilitarioSeguranca {

	private UtilitarioSeguranca() {
	}

	public static String getUsuarioLogado() {
		Preconditions.checkState(estaLogado());
		return getUserPrincipal().getName();
	}

	public static void login(Usuario usuario) throws ServletException {
		FacesUtil.getServletRequest().login(usuario.getLogin(),
				usuario.getSenha());
	}

	public static void logout() {
		if (estaLogado()) {
			HttpSession session = (HttpSession) FacesUtil.getExternalContext()
					.getSession(false);
			session.invalidate();
		}
	}

	public static boolean estaLogado() {
		return getUserPrincipal() != null;
	}

	public static Principal getUserPrincipal() {
		return FacesUtil.getExternalContext().getUserPrincipal();
	}

	public static boolean verificaPapelUsuario(String papel) {
		return FacesUtil.getExternalContext().isUserInRole(papel);
	}
}
