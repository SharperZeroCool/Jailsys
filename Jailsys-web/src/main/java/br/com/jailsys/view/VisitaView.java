package br.com.jailsys.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jailsys.model.Visita;
import br.com.jailsys.qualifier.VisitaBean;

@Named
public class VisitaView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360706983342901884L;
	
	@Inject
	@VisitaBean
	private Visita visita;
	
	private List<Visita> visitas = new ArrayList<Visita>();

	//GETTERS E SETTERS
	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

}
