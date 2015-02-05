package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.service.PessoaService;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.PessoaView;

@ManagedBean
@ViewScoped
public class PessoaBean implements AbstractBean<EntidadeComum>, Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1474196752557439140L;
    
    @Inject
    private PessoaView pessoaView;
    
    @Inject
    private PessoaService service;
    
    private final String PESSOA_CONSULTA = "pessoaConsulta.xhtml";
    private final String PESSOA_CADASTRO = "pessoaCadastro.xhtml";
    private final String PESSOA_EDICAO = "pessoaEdicao.xhtml";
    private final String MENSAGEM_CADASTRO = "jailsysweb.pessoa.cadastro.sucesso";
    private final String MENSAGEM_EDICAO = "jailsysweb.pessoa.edicao.sucesso";
    private final String MENSAGEM_EXCLUSAO = "jailsysweb.pessoa.exclusao.sucesso";

    public List<Pessoa> listar() {
        if(pessoaView.getPessoas().isEmpty()) {
            this.atualizarView();
        }
        return pessoaView.getPessoas();
    }
    
    @Override
    public String prepararInclusao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String prepararEdicao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String salvar() {
        service.salvar(pessoaView.getPessoa());
        this.atualizarView();
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_CADASTRO);
        return PESSOA_CONSULTA;
    }

    @Override
    public void atualizarView() {
        pessoaView.setPessoas(service.listar());
    }

    @Override
    public String editar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visualizar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(EntidadeComum entidade) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public PessoaView getPessoaView() {
        return pessoaView;
    }
    
    public void setPessoaView(PessoaView pessoaView) {
        this.pessoaView = pessoaView;
    }
    
}
