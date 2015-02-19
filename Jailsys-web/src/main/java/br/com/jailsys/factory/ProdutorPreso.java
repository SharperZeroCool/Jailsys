package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.google.common.base.Strings;

import br.com.jailsys.model.Preso;
import br.com.jailsys.qualifier.PresoBean;
import br.com.jailsys.service.PresoService;
import br.com.jailsys.util.FacesUtil;

public class ProdutorPreso {
	@Inject
	PresoService presoService;

	@Produces
	@PresoBean
	public Preso produzirPreso() {
		Preso preso = new Preso();
		preso.setAtivo(Boolean.TRUE);
		String id = FacesUtil.getRequestParameter("idPreso");
		if (!Strings.isNullOrEmpty(id)) {
			Long idLong = new Long(id);
			preso = (Preso) presoService.buscar(idLong);
		}
		return preso;
	}

}
