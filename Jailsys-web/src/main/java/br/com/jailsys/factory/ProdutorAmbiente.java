package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.google.common.base.Strings;

import br.com.jailsys.model.Ambiente;
import br.com.jailsys.qualifier.AmbienteBean;
import br.com.jailsys.service.AmbienteService;
import br.com.jailsys.util.FacesUtil;

public class ProdutorAmbiente {

	@Inject
	AmbienteService ambienteService;

	@Produces
	@AmbienteBean
	public Ambiente produzirAmbiente() {
		Ambiente ambiente = new Ambiente();
		ambiente.setAtivo(Boolean.TRUE);
		String id = FacesUtil.getRequestParameter("idAmbiente");
		if (!Strings.isNullOrEmpty(id)) {
			Long idLong = new Long(id);
			ambiente = (Ambiente) ambienteService.buscar(idLong);
		}

		return ambiente;
	}
}
