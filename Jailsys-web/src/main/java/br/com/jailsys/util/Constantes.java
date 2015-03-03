package br.com.jailsys.util;

public class Constantes {
	public static final class Pessoa {
		public static final String TELA_CONSULTA = "/pessoa/pessoaConsulta.xhtml";
		public static final String TELA_CADASTRO = "/pessoa/pessoaCadastro.xhtml";
		public static final String TELA_EDICAO = "/pessoa/pessoaEdicao.xhtml";
		public static final String TELA_VISUALIZAR = "/pessoa/pessoaFormulario.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.pessoa.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.pessoa.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.pessoa.exclusao.sucesso";

		public static final String TIPO_FUNCIONARIO = "jailsysweb.pessoa.form.cadastro.label.funcionario";
		public static final String TIPO_PRESO = "jailsysweb.pessoa.form.cadastro.label.preso";
		public static final String TIPO_VISITANTE = "jailsysweb.pessoa.form.cadastro.label.visitante";

		public static final String PAGINA_FUNCIONARIO = "../funcionario/funcionarioCadastro.xhtml";
		public static final String PAGINA_PRESO = "../preso/presoCadastro.xhtml";
		public static final String PAGINA_VISITANTE = "visitanteCadastro.xhtml";
	}

	public static final class Funcionario {
		public static final String TELA_CONSULTA = "/funcionario/funcionarioConsulta.xhtml";
		public static final String TELA_CADASTRO = "/funcionario/funcionarioCadastro.xhtml";
		public static final String TELA_EDICAO = "/funcionario/funcionarioEdicao.xhtml";
		public static final String TELA_VISUALIZAR = "/funcionario/funcionarioInclude.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.funcionario.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.funcionario.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.funcionario.exclusao.sucesso";
	}

	public static final class Preso {
		public static final String TELA_CONSULTA = "/preso/presoConsulta.xhtml";
		public static final String TELA_CADASTRO = "/preso/presoCadastro.xhtml";
		public static final String TELA_EDICAO = "/preso/presoEdicao.xhtml";
		public static final String TELA_VISUALIZAR = "/preso/presoInclude.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.preso.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.preso.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.preso.exclusao.sucesso";
	}

	public static final class Ambiente {
		public static final String TELA_CONSULTA = "/ambiente/ambienteConsulta.xhtml";
		public static final String TELA_CADASTRO = "/ambiente/ambienteCadastro.xhtml";
		public static final String TELA_EDICAO = "/ambiente/ambienteEdicao.xhtml";
		public static final String TELA_VISUALIZAR = "/ambiente/ambienteFormulario.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.ambiente.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.ambiente.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.ambiente.exclusao.sucesso";
	}

	public static final class Atividade {
		public static final String TELA_CONSULTA = "/atividade/atividadeConsulta.xhtml";
		public static final String TELA_CADASTRO = "/atividade/atividadeCadastro.xhtml";
		public static final String TELA_EDICAO = "/atividade/atividadeEdicao.xhtml";
		public static final String TELA_VISUALIZAR = "/atividade/atividadeFormulario.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.atividade.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.atividade.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.atividade.exclusao.sucesso";
	}

	public static final class Usuario {
		public static final String TELA_CONSULTA = "/usuario/usuarioConsulta.xhtml";
		public static final String TELA_CADASTRO = "/usuario/usuarioCadastro.xhtml";
		public static final String TELA_EDICAO = "/usuario/usuarioEdicao.xhtml";
		public static final String TELA_VISUALIZAR = "/usuario/usuarioFormulario.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.usuario.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.usuario.edicao.sucesso";
		public static final String MENSAGEM_ERROR_EDICAO = "jailsysweb.erro.mensagem.usuario.edicao.senhaErrada";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.usuario.exclusao.sucesso";
	}

	public static final class Login {
		public static final String MENSAGEM_USUARIO_SENHA_INVALIDO = "jailsysweb.erro.mensagem.usuario.senha.invalidos";
		public static final String MENSAGEM_ERROR_LOGIN = "jailsysweb.erro.mensagem.efetuar.login";
		public static final String TELA_INICIAL = "/index.xhtml?faces-redirect=true";
		public static final String TELA_LOGIN = "login.xhtml";
	}

}
