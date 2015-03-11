package br.com.jailsys.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.jailsys.util.CriptografiaUtil;
import br.com.jailsys.util.EmailUtil;

import com.google.common.base.Strings;

@Entity
public class Usuario extends EntidadeComum implements Serializable {

	private static final long serialVersionUID = 1801799201648626978L;

	@Column(length = 100, nullable = false, unique = true)
	private String login;

	@Column(length = 100, nullable = false)
	private char[] senha;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinColumn(name = "grupo")
	private Grupo grupo;

	@Column(nullable = false)
	private boolean ativo;

	private static final String ASSUNTO_EMAIL_CRUD = "Alteração de Cadastro no Sistema Jailsys";
	private static final String ASSUNTO_EMAIL_DIARIO = "Sistema Jailsys - Boletim";

	public void criptografarSenha() {
		this.setSenha(getSenhaCriptografada());
	}

	public void enviarEmailDiario() {
		EmailUtil.enviarEmail(pessoa.getEmail(), ASSUNTO_EMAIL_DIARIO,
				getConteudoEmailDiario());
	}

	public void enviarEmailCriacao() {
		EmailUtil.enviarEmail(pessoa.getEmail(), ASSUNTO_EMAIL_CRUD,
				getConteudoEmailSalvarUsuario());
	}

	public void enviarEmailEdicao() {
		EmailUtil.enviarEmail(pessoa.getEmail(), ASSUNTO_EMAIL_CRUD,
				getConteudoEmailEditarUsuario());
	}

	public void enviarEmailExclusao() {
		EmailUtil.enviarEmail(pessoa.getEmail(), ASSUNTO_EMAIL_CRUD,
				getConteudoEmailDeletarUsuario());
	}

	@Override
	public String getDescricaoPesquisa() {
		return login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha != null ? String.valueOf(senha) : null;
	}

	public void setSenha(String senha) {
		if (!Strings.isNullOrEmpty(senha))
			this.senha = senha.toCharArray();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	private String getSenhaCriptografada() {
		return CriptografiaUtil.criptografar(this.getSenha());
	}

	private String getConteudoEmailDiario() {
		// TODO trocar esta mensagem por um template do velocity
		return "Caro " + pessoa.getNome() + ",\nEstá na hora de almoçar!";
	}

	private String getConteudoEmailSalvarUsuario() {
		// TODO trocar esta mensagem por um template do velocity
		return "Parabéns " + pessoa.getNome()
				+ "!\nSua nova conta de usuário com o nome: " + login
				+ " foi criada com sucesso!";
	}

	private String getConteudoEmailEditarUsuario() {
		// TODO trocar esta mensagem por um template do velocity
		return "Caro " + pessoa.getNome()
				+ ",\nSua conta de usuário com o nome: " + login
				+ " foi editada com sucesso!";
	}

	private String getConteudoEmailDeletarUsuario() {
		// TODO trocar esta mensagem por um template do velocity
		return "Caro " + pessoa.getNome()
				+ ",\nSua conta de usuário com o nome: " + login
				+ " foi excluida com sucesso!";
	}

}
