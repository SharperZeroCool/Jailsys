package br.com.jailsys.service;

import java.util.List;

import br.com.jailsys.DAO.UsuarioDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Usuario;

public class UsuarioService implements AbstractService<EntidadeComum> {
    
    
    UsuarioDAO usuarioDao;
    
    
    @Override
    public void salvar(EntidadeComum entidade) {
        usuarioDao.salvar((Usuario) entidade);
    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
        return usuarioDao.salvarERetornar((Usuario) entidade);
    }

    @Override
    public void editar(EntidadeComum entidade) {
         usuarioDao.atualizar((Usuario) entidade);
    }

    @Override
    public void excluir(Long id) {
        usuarioDao.delete(id);
        
    }

    @Override
    public void buscar(Long id) {
        usuarioDao.buscar(id);
        
    }


    public List<Usuario> consultar() {
        return usuarioDao.listar(); 
    }

}
