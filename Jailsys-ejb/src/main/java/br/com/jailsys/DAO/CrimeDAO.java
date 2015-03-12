package br.com.jailsys.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.jailsys.model.Crime;

@Stateless
public class CrimeDAO extends GenericDAO<Crime> implements Serializable {

    private static final long serialVersionUID = -4896372501898182132L;
    
}
