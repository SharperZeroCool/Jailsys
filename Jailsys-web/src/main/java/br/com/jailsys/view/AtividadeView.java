package br.com.jailsys.view;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.Severidade;
import br.com.jailsys.qualifier.AtividadeBean;

@Named
public class AtividadeView {

	@Inject
	@AtividadeBean
	private Atividade atividade;

	private List<Atividade> atividades = new ArrayList<Atividade>();
	
	public Severidade[] getSeveridade() {
		return Severidade.values();
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

}
