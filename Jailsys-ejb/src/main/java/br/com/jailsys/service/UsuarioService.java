package br.com.jailsys.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.UsuarioDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Grupo;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.model.Usuario;

public class UsuarioService implements AbstractService<EntidadeComum>,
        Serializable {

    private static final long serialVersionUID = 1028924301178170070L;
    @Inject
    UsuarioDAO usuarioDao;

    @Override
    public void salvar(EntidadeComum entidade) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpfCnpj("asdasd");
        pessoa.setDataNasc(new Date());
        pessoa.setEmail("asdasd");
        pessoa.setNome("asdasd");
        Grupo grupo = new Grupo();
        grupo.setDescricao("aasdasd");
        grupo.setNome("asdasd");
        Usuario usuario = (Usuario) entidade;
        usuario.setPessoa(pessoa);
        usuario.setGrupo(grupo);
        usuario.criptografarSenha();
        usuarioDao.salvar((Usuario) entidade);
    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
        return usuarioDao.salvarERetornar((Usuario) entidade);
    }

    @Override
    public void editar(EntidadeComum entidade) {
        usuarioDao.editar((Usuario) entidade);
    }

    @Override
    public void excluir(Long id) {
        Usuario usuario = (Usuario) buscar(id);
        excluir(usuario);
    }

    @Override
    public void excluir(EntidadeComum entidade) {
        ((Usuario) entidade).setAtivo(Boolean.FALSE);
        usuarioDao.editar((Usuario) entidade);
    }

    @Override
    public EntidadeComum buscar(Long id) {
        return usuarioDao.buscar(id);
    }

    public List<Usuario> listar() {
        return usuarioDao.listar();
    }

}
