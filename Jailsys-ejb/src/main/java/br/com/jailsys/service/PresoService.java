package br.com.jailsys.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.PresoDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Preso;


public class PresoService implements AbstractService<EntidadeComum>, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8243931725677708911L;
        @Inject
        PresoDAO presoDao;
        
        
    @Override
    public void salvar(EntidadeComum entidade) {
       Preso preso = (Preso) entidade;
       preso.setCelular("9999-4646");
       preso.setAtivo(Boolean.TRUE);
       preso.setCpf("125.556.886-09");
       preso.setEmail("sasas@sas.com");
       preso.setNome("LUIZ GUILHERME RODRIGUES");      
       preso.setDataNasc(new Date());
       preso.setCodigo("65464454545");
       presoDao.salvar((Preso) entidade);      
    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
       return presoDao.salvarERetornar((Preso) entidade);
    }

    @Override
    public void editar(EntidadeComum entidade) {
        presoDao.editar((Preso)entidade);
    }

    @Override
    public void excluir(Long id) {
         Preso preso = (Preso) buscar(id);  
         excluir(preso);
    }

    @Override
    public void excluir(EntidadeComum entidade) {
        Preso preso = (Preso) entidade;
        preso.setAtivo(Boolean.FALSE);
        presoDao.editar(preso);    
    }

    @Override
    public EntidadeComum buscar(Long id) {
        return presoDao.buscar(id);
    }
    
    public List<Preso> listar(){
        return presoDao.listarAtivo();
    }

    


}