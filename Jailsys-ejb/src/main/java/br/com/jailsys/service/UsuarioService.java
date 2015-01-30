package br.com.jailsys.service;

import java.util.List;

import javax.ejb.Stateless;

import br.com.jailsys.model.EntidadeComum;

@Stateless
public class UsuarioService implements AbstractService<EntidadeComum> {

    @Override
    public void salvar(EntidadeComum entidade) {
        // TODO Auto-generated method stub

    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void editar(EntidadeComum entidade) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<EntidadeComum> consultar() {
        // TODO Auto-generated method stub
        return null;
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
    public void buscar(Long id) {
        // TODO Auto-generated method stub

    }

}
