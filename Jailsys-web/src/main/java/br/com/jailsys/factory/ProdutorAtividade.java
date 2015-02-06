package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.jailsys.model.Atividade;
import br.com.jailsys.qualifier.AtividadeBean;
import br.com.jailsys.service.AtividadeService;
import br.com.jailsys.util.FacesUtil;

import com.google.common.base.Strings;

public class ProdutorAtividade {

    @Inject
    private AtividadeService atividadeService;

    @Produces
    @AtividadeBean
    public Atividade produzirAtividade() {
        Atividade atividade = new Atividade();
        String id = FacesUtil.getRequestParameter("idAtividade");
        if (!Strings.isNullOrEmpty(id)) {
            Long idLong = new Long(id);
            atividade = (Atividade) atividadeService.buscar(idLong);
        }
        return atividade;
    }

}
