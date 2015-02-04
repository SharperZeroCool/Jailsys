package br.com.jailsys.service;

import javax.inject.Inject;

import br.com.jailsys.DAO.PessoaDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;

public class PessoaService implements AbstractService<EntidadeComum> {
    
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

}
