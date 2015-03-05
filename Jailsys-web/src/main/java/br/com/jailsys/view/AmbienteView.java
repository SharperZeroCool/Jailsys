package br.com.jailsys.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.qualifier.AmbienteBean;

@Named
public class AmbienteView implements Serializable {

	private static final long serialVersionUID = 6307050706770313961L;

	@Inject
	@AmbienteBean
	private Ambiente ambiente;

	private List<Ambiente> ambientes = new ArrayList<Ambiente>();
	
	private DualListModel<Atividade> atividadesDualList;

	//GETTERS E SETTERS
	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public List<Ambiente> getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

	public DualListModel<Atividade> getAtividadesDualList() {
		return atividadesDualList;
	}

	public void setAtividadesDualList(DualListModel<Atividade> atividadesDualList) {
		this.atividadesDualList = atividadesDualList;
	}
}
