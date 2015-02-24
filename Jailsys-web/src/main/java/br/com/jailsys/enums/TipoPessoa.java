package br.com.jailsys.enums;

import br.com.jailsys.util.Constantes;

public enum TipoPessoa {
	FUNCIONARIO(Constantes.Pessoa.TIPO_FUNCIONARIO, Constantes.Pessoa.PAGINA_FUNCIONARIO),
	PRESO(Constantes.Pessoa.TIPO_PRESO, Constantes.Pessoa.PAGINA_PRESO),
	VISITANTE(Constantes.Pessoa.TIPO_VISITANTE, Constantes.Pessoa.PAGINA_VISITANTE);

	private String label;
	private String pagina;

	private TipoPessoa(String label, String pagina) {
		this.label = label;
		this.pagina = pagina;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
}
