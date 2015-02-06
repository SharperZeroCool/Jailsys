package br.com.jailsys.service;

import java.io.Serializable;
import java.util.Calendar;
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

    private final String PONTO = ".";

    private final int REMOVE_PONTO = 1;

    private final String HIFEN = "-";

    private final String VAZIO = "";

    @Override
    public void salvar(EntidadeComum entidade) {
        Funcionario funcionario = (Funcionario) entidade;
        mockPessoa(funcionario);
        funcionario.setCodigo(geradorDeCodigo(funcionario));
        funcionarioDao.salvar(funcionario);
    }

    private void mockPessoa(EntidadeComum entidade) {
        Funcionario funcionario = (Funcionario) entidade;
        funcionario.setAtivo(Boolean.TRUE);
        funcionario.setCelular("(32)9999-9999");
        funcionario.setCpf("100.209.306-66");
        funcionario.setDataNasc(new Date());
        funcionario.setEmail("email@email.com");
        funcionario.setNome("Nome Pessoa");
    }

    /**
     * Gera o codigo do funcionario no seguinte formato: ANO DE NASCIMENTO + 5
     * ULTIMOS DIGITOS DO CPF + ANO DE ENTRADA + MES DE ENTRADA.
     * 
     * @param funcionario
     * @return Codigo do funcionario no formato correto.
     */
    public String geradorDeCodigo(Funcionario funcionario) {
        StringBuilder codigo = new StringBuilder();

        // Pega o ano de nascimento do funcionario
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(funcionario.getDataNasc());
        codigo.append(calendario.get(Calendar.YEAR));

        // Pega os ultimos 5 digitos do cpf do funcionario
        codigo.append(funcionario.getCpf().substring(funcionario.getCpf().lastIndexOf(PONTO) + REMOVE_PONTO).replace(HIFEN, VAZIO));

        // Pega o ano e mes de entrada do funcionario
        calendario.setTime(funcionario.getDataEntrada());
        codigo.append(calendario.get(Calendar.YEAR));
        codigo.append(calendario.get(Calendar.MONTH));
        return codigo.toString();
    }

    @Override
    public EntidadeComum salvarERetornar(EntidadeComum entidade) {
        ((Funcionario) entidade).setCodigo(geradorDeCodigo((Funcionario) entidade));
        return funcionarioDao.salvarERetornar((Funcionario) entidade);
    }

    @Override
    public void editar(EntidadeComum entidade) {
        ((Funcionario) entidade).setCodigo(geradorDeCodigo((Funcionario) entidade));
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
    
    public List<Funcionario> listarItensAtivos(){
        return funcionarioDao.listarItensAtivos();
    }

}
