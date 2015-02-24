package br.com.jailsys.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.jailsys.model.Grupo;

@Stateless
public class GrupoDAO extends GenericDAO<Grupo> implements Serializable {

	private static final long serialVersionUID = 3307914183564738470L;

}
