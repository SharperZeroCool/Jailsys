package br.com.jailsys.view;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.jailsys.model.EntidadeComum;

@Named
public class PesquisaView {

	private String termoPesquisa;

	private List<EntidadeComum> resultado = new ArrayList<EntidadeComum>();

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public List<EntidadeComum> getResultado() {
		return resultado;
	}

	public void setResultado(List<EntidadeComum> resultado) {
		this.resultado = resultado;
	}

	public void addResultado(EntidadeComum entidade) {
		this.resultado.add(entidade);
	}

	public void addResultados(List<EntidadeComum> entidades) {
		this.resultado.addAll(entidades);
	}

}
