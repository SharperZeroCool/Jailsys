package br.com.jailsys.util;

public class Constantes {
	public static final class Pessoa {
		public static final String TELA_CONSULTA = "/pessoa/pessoaConsulta.xhtml";
		public static final String TELA_CADASTRO = "/pessoa/pessoaCadastro.xhtml";
		public static final String TELA_VISUALIZAR = "/pessoa/pessoaInclude.xhtml";
		public static final String TELA_EDICAO = "/pessoa/pessoaEdicao.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.pessoa.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.pessoa.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.pessoa.exclusao.sucesso";

		public static final String FUNCIONARIO = "jailsysweb.pessoa.form.cadastro.label.funcionario";
		public static final String PRESO = "jailsysweb.pessoa.form.cadastro.label.preso";
		public static final String VISITANTE = "jailsysweb.pessoa.form.cadastro.label.visitante";

		public static final String PAGINA_FUNCIONARIO = "../funcionario/funcionarioCadastro.xhtml";
		public static final String PAGINA_PRESO = "../preso/presoCadastro.xhtml";
		public static final String PAGINA_VISITANTE = "visitanteCadastro.xhtml";
	}

	public static final class Funcionario {
		public static final String TELA_CADASTRO = "/funcionario/funcionarioCadastro.xhtml";
		public static final String TELA_CONSULTA = "/funcionario/funcionarioConsulta.xhtml";
		public static final String TELA_VISUALIZAR = "/funcionario/funcionarioInclude.xhtml";
		public static final String TELA_EDICAO = "/funcionario/funcionarioEdicao.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.funcionario.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.funcionario.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.funcionario.exclusao.sucesso";
	}

	public static final class Preso {
		public static final String TELA_CADASTRO = "/preso/presoCadastro.xhtml";
		public static final String TELA_CONSULTA = "/preso/presoConsulta.xhtml";
		public static final String TELA_EDICAO = "/preso/presoEdicao.xhtml";
		public static final String TELA_VISUALIZAR = "/preso/presoInclude.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.preso.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.preso.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.preso.exclusao.sucesso";
	}

	public static final class Ambiente {
		public static final String TELA_CADASTRO = "ambienteCadastro.xhtml";
		public static final String TELA_CONSULTA = "ambienteConsulta.xhtml";
		public static final String TELA_EDICAO = "ambienteEdicao.xhtml";
		public static final String MENSAGEM_CADASTRO = "jailsysweb.ambiente.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.ambiente.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.ambiente.exclusao.sucesso";
	}

	public static final class Atividade {
		public static final String MENSAGEM_CADASTRO = "jailsysweb.atividade.cadastro.sucesso";
		public static final String MENSAGEM_EDICAO = "jailsysweb.atividade.edicao.sucesso";
		public static final String MENSAGEM_EXCLUSAO = "jailsysweb.atividade.exclusao.sucesso";
		public static final String TELA_EDICAO = "atividadeEdicao";
		public static final String TELA_CONSULTA = "atividadeConsulta";
	}

}
