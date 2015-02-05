package br.com.jailsys.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.PessoaDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;

public class PessoaService implements AbstractService<EntidadeComum>, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6623540764664272252L;
    
    @Inject
    PessoaDAO pessoaDao;
    
    @Override
    public void salvar(EntidadeComum entidade) {
        pessoaDao.salvar((Pessoa) entidade);
    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
        pessoaDao.salvarERetornar((Pessoa) entidade);
        return (Pessoa) entidade;
    }

    @Override
    public void editar(EntidadeComum entidade) {
        // TODO Auto-generated method stub

    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void excluir(EntidadeComum entidade) {
        // TODO Auto-generated method stub

    }

    @Override
    public EntidadeComum buscar(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<Pessoa> listar() {
        return pessoaDao.listar();
    }

}
