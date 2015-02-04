package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.jailsys.model.Funcionario;
import br.com.jailsys.qualifier.FuncionarioBean;
import br.com.jailsys.service.FuncionarioService;
import br.com.jailsys.util.FacesUtil;

import com.google.common.base.Strings;

public class ProdutorFuncionario {
    @Inject
    private FuncionarioService funcionarioService;

    @Produces
    @FuncionarioBean
    public Funcionario produzirFuncionario() {
        Funcionario funcionario = new Funcionario();
        String id = FacesUtil.getRequestParameter("idFuncionario");
        if (!Strings.isNullOrEmpty(id)) {
            Long idLong = new Long(id);
            funcionario = (Funcionario) funcionarioService.buscar(idLong);
        }
        return funcionario;
    }
}
