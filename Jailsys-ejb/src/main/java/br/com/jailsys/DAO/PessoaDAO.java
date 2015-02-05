package br.com.jailsys.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.jailsys.model.Pessoa;

@Stateless
public class PessoaDAO extends GenericDAO<Pessoa> implements
        Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7750379895631731135L;

}
