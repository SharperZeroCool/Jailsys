package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Funcionario;
import br.com.jailsys.service.FuncionarioService;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.FuncionarioView;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements AbstractBean<EntidadeComum>,
        Serializable {

    private static final long serialVersionUID = -6274814536790349940L;

    private final String TELA_CADASTRO = "funcionarioCadastro.xhtml";
    private final String TELA_CONSULTA = "funcionarioConsulta.xhtml";
    private final String TELA_EDICAO = "funcionarioEdicao.xhtml";
    private final String MENSAGEM_CADASTRO = "jailsysweb.funcionario.cadastro.sucesso";
    private final String MENSAGEM_EDICAO = "jailsysweb.funcionario.edicao.sucesso";
    private final String MENSAGEM_EXCLUSAO = "jailsysweb.funcionario.exclusao.sucesso";

    @Inject
    FuncionarioService service;

    @Inject
    FuncionarioView funcionarioView;

    public List<Funcionario> listar() {
        if (funcionarioView.getFuncionarios().isEmpty()) {
            this.atualizarView();
        }
        return funcionarioView.getFuncionarios();
    }

    @Override
    public String prepararInclusao() {
        return TELA_CADASTRO;
    }

    @Override
    public String prepararEdicao() {
        return TELA_EDICAO;
    }

    @Override
    public String salvar() {
        service.salvar(funcionarioView.getFuncionario());
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_CADASTRO);
        this.atualizarView();
        return TELA_CONSULTA;
    }

    @Override
    public void atualizarView() {
        funcionarioView.setFuncionarios(service.listar());
    }

    @Override
    public String editar() {
        service.editar(funcionarioView.getFuncionario());
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_EDICAO);
        return TELA_CONSULTA;
    }

    @Override
    public String visualizar() {
        return TELA_EDICAO;
    }

    @Override
    public String excluir(EntidadeComum funcionario) {
        service.excluir(funcionario);
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_EXCLUSAO);
        return TELA_CONSULTA;
    }

    public FuncionarioView getFuncionarioView() {
        return funcionarioView;
    }

    public void setFuncionarioView(FuncionarioView funcionarioView) {
        this.funcionarioView = funcionarioView;
    }

}
