package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Preso;
import br.com.jailsys.service.PresoService;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.PresoView;

@ManagedBean
@ViewScoped
public class PresoBean implements AbstractBean<EntidadeComum>, Serializable {

    private static final long serialVersionUID = -8523743092556986021L;
    
    private final String TELA_CADASTRO = "presoCadastro.xhtml";
    private final String TELA_CONSULTA = "presoConsulta.xhtml";
    private final String TELA_EDICAO = "presoEdicao.xhtml";
    private final String MENSAGEM_CADASTRO = "jailsysweb.preso.cadastro.sucesso";
    private final String MENSAGEM_EDICAO = "jailsysweb.preso.edicao.sucesso";
    private final String MENSAGEM_EXCLUSAO = "jailsysweb.preso.exclusao.sucesso";
    
    @Inject
    PresoService service;
    
    @Inject
    PresoView presoView;

    public PresoView getPresoView() {
        return presoView;
    }

    public void setPresoView(PresoView presoView) {
        this.presoView = presoView;
    }

    public List<Preso> listar(){
        if (presoView.getPresos().isEmpty()){
            this.atualizarView();
        }
       return presoView.getPresos();
    }
    
    @Override
    public String prepararInclusao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String prepararEdicao() {
        return TELA_EDICAO;
    }

    @Override
    public String salvar() {
        service.salvar(presoView.getPreso());
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_CADASTRO);
        this.atualizarView();
        return TELA_CONSULTA;
    }

    @Override
    public void atualizarView() {
        presoView.setPresos(service.listar());
        
    }

    @Override
    public String editar() {
        service.editar(presoView.getPreso());
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_EDICAO);
        return TELA_CONSULTA;
    }

    @Override
    public String visualizar() {
        return TELA_CADASTRO;
    }

    @Override
    public String excluir(EntidadeComum entidade) {
       service.excluir(entidade);
       FacesUtil.mostrarMensagemSucesso(MENSAGEM_EXCLUSAO);
       return TELA_CONSULTA;
    }
    

}
