package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.jailsys.model.Preso;

@Stateless
public class PresoDAO extends GenericDAO<Preso> implements Serializable {

    private static final long serialVersionUID = -5038738004256802472L;

    @SuppressWarnings("unchecked")
    public List<Preso> listarAtivo() {
        return getEntityManager().createQuery("FROM Preso p Where p.ativo=true").getResultList();
    }

}
