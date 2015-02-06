package br.com.jailsys.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.jailsys.model.Ambiente;

@Stateless
public class AmbienteDAO extends GenericDAO<Ambiente> implements Serializable {

    private static final long serialVersionUID = 5343361632900144662L;

}
