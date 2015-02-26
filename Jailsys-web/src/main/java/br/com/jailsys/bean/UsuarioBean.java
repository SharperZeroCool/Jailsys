package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Grupo;
import br.com.jailsys.model.Usuario;
import br.com.jailsys.service.UsuarioService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.UsuarioView;

import com.google.common.base.Strings;

@ManagedBean
@ViewScoped
public class UsuarioBean implements AbstractBean<EntidadeComum>, Serializable {

	private static final long serialVersionUID = 2256641221649626781L;

	@Inject
	private UsuarioService service;

	@Inject
	private UsuarioView usuarioView;

	@Resource(lookup = "java:jboss/mail/outlook")
	private Session mailSession;

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
		service.salvar(usuarioView.getUsuario());
		enviarEmail(usuarioView.getUsuario(),
				getConteudoEmailSalvarUsuario(usuarioView.getUsuario()));
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
		if (service.isSenhaCorreta(usuarioView.getUsuario(),
				usuarioView.getSenhaAtual())) {
			service.editar(usuarioView.getUsuario());
			enviarEmail(usuarioView.getUsuario(),
					getConteudoEmailEditarUsuario(usuarioView.getUsuario()));
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
	public String excluir(EntidadeComum usuario) {
		service.excluir(usuario);
		enviarEmail((Usuario) usuario,
				getConteudoEmailDeletarUsuario((Usuario) usuario));
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

	private String getConteudoEmailSalvarUsuario(Usuario usuario) {
		return "Parabéns " + usuario.getPessoa().getNome()
				+ "!\nSua nova conta de usuário com o nome: "
				+ usuario.getLogin() + " foi criada com sucesso!";
	}

	private String getConteudoEmailEditarUsuario(Usuario usuario) {
		return "Caro " + usuario.getPessoa().getNome()
				+ ",\nSua conta de usuário com o nome: " + usuario.getLogin()
				+ " foi editada com sucesso!";
	}

	private String getConteudoEmailDeletarUsuario(Usuario usuario) {
		return "Caro " + usuario.getPessoa().getNome()
				+ ",\nSua conta de usuário com o nome: " + usuario.getLogin()
				+ " foi excluida com sucesso!";
	}

	private void enviarEmail(Usuario usuario, String conteudo) {
		if (possuiEmail(usuario)) {
			String to = usuario.getPessoa().getEmail();

			mailSession.getProperties();

			String from = mailSession.getProperty("mail.smtp.user");

			try {
				MimeMessage message = new MimeMessage(mailSession);

				message.setFrom(new InternetAddress(from));

				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));

				message.setSubject(Constantes.Usuario.ASSUNTO_EMAIL);

				message.setContent(conteudo, "text/plain");

				Transport.send(message);
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}
	}

	private static boolean possuiEmail(Usuario usuario) {
		return !Strings.isNullOrEmpty(usuario.getPessoa().getEmail());
	}

}
