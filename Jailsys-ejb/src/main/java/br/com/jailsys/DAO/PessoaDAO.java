package br.com.jailsys.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.jailsys.model.Pessoa;

@Stateless
@SuppressWarnings("unchecked")
public class PessoaDAO extends GenericDAO<Pessoa> implements
        Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7750379895631731135L;
 
    public List<Pessoa> listarItensAtivos() {
        return getEntityManager().createQuery(
                "FROM Pessoa o WHERE o.ativo = true")
                .getResultList();
    }
    
    public List<Pessoa> listarVisitantes(){
    	String hql = "FROM Pessoa p WHERE p.ativo=true AND (p.id NOT IN(SELECT f.id FROM Funcionario f) AND p.id NOT IN(SELECT pr.id FROM Preso pr))";
    	return getEntityManager().createQuery(hql).getResultList();
    }

}
