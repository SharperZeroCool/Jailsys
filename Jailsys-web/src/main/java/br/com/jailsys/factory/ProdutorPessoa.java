package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.jailsys.model.Pessoa;
import br.com.jailsys.qualifier.PessoaBean;
import br.com.jailsys.service.PessoaService;
import br.com.jailsys.util.FacesUtil;

import com.google.common.base.Strings;

public class ProdutorPessoa {
    @Inject
    private PessoaService pessoaService;
    
    @Produces
    @PessoaBean
    public Pessoa produzirPessoa() {
        Pessoa pessoa = new Pessoa();
        String id = FacesUtil.getRequestParameter("idPessoa");
        if(!Strings.isNullOrEmpty(id))
            pessoa = (Pessoa) pessoaService.buscar(Long.parseLong(id));
        
        return pessoa;
    }
}
