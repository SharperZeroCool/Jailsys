package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.google.common.base.Strings;

import br.com.jailsys.model.Visita;
import br.com.jailsys.qualifier.VisitaBean;
import br.com.jailsys.service.VisitaService;
import br.com.jailsys.util.FacesUtil;

public class ProdutorVisita {

	@Inject
	private VisitaService visitaService;

	@Produces
	@VisitaBean
	public Visita produzirVisita() {
		Visita visita = new Visita();
		String id = FacesUtil.getRequestParameter("idVisita");
		if (!Strings.isNullOrEmpty(id)) {
			Long idLong = new Long(id);
			visita = (Visita) visitaService.buscar(idLong);
		}
		return visita;
	}

}
