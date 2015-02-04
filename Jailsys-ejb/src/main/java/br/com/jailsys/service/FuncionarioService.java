package br.com.jailsys.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.jailsys.DAO.FuncionarioDAO;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Funcionario;

public class FuncionarioService implements AbstractService<EntidadeComum>,
        Serializable {

    private static final long serialVersionUID = -2778179835214452854L;

    @Inject
    FuncionarioDAO funcionarioDao;

    @Override
    public void salvar(EntidadeComum entidade) {
        Funcionario funcionario = (Funcionario) entidade;
        funcionario.setAtivo(Boolean.TRUE);
        funcionario.setCelular("(32)9999-9999");
        funcionario.setCodigo("123");
        funcionario.setCpf("100.209.306-66");
        funcionario.setDataNasc(new Date());
        funcionario.setEmail("email@email.com");
        funcionario.setNome("Nome Pessoa");
        funcionarioDao.salvar((Funcionario) entidade);
    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
        return funcionarioDao.salvarERetornar((Funcionario) entidade);
    }

    @Override
    public void editar(EntidadeComum entidade) {
        funcionarioDao.editar((Funcionario) entidade);
    }

    @Override
    public void excluir(Long id) {
        Funcionario funcionario = funcionarioDao.buscar(id);
        excluir(funcionario);
    }

    @Override
    public void excluir(EntidadeComum entidade) {
        ((Funcionario) entidade).setAtivo(Boolean.FALSE);
        funcionarioDao.editar((Funcionario) entidade);
    }

    @Override
    public EntidadeComum buscar(Long id) {
        return funcionarioDao.buscar(id);
    }

    public List<Funcionario> listar() {
        return funcionarioDao.listar();
    }

}
