package br.com.jailsys.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.jailsys.model.Funcionario;

@Stateless
public class FuncionarioDAO extends GenericDAO<Funcionario> implements
        Serializable {

    private static final long serialVersionUID = -3325896059017717362L;

}
