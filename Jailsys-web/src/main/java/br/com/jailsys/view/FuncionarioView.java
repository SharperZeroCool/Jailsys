package br.com.jailsys.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jailsys.model.Funcionario;
import br.com.jailsys.qualifier.FuncionarioBean;

@Named
public class FuncionarioView implements Serializable {

    private static final long serialVersionUID = 6673863199140636556L;

    @Inject
    @FuncionarioBean
    private Funcionario funcionario;

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
