package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.service.AtividadeService;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.AtividadeView;

@ManagedBean
@ViewScoped
public class AtividadeBean implements Serializable, AbstractBean<EntidadeComum> {

    private static final long serialVersionUID = 7961530823602276424L;

    private final String MENSAGEM_CADASTRO = "jailsysweb.atividade.cadastro.sucesso";
    private final String MENSAGEM_EDICAO = "jailsysweb.atividade.edicao.sucesso";
    private final String MENSAGEM_EXCLUSAO = "jailsysweb.atividade.exclusao.sucesso";
    private final String TELA_EDICAO = "atividadeEdicao";
    private final String TELA_CONSULTA = "atividadeConsulta";

    @Inject
    private AtividadeService service;

    @Inject
    private AtividadeView atividadeView;

    public List<Atividade> listarPorAtivo() {
        if (atividadeView.getAtividades().isEmpty()) {
            atualizarView();
        }
        return atividadeView.getAtividades();
    }

    @Override
    public String prepararInclusao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String prepararEdicao() {
        // TODO Auto-generated method stub
        return TELA_EDICAO;
    }

    @Override
    public String salvar() {
        service.salvar(atividadeView.getAtividade());
        atualizarView();
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_CADASTRO);
        return TELA_CONSULTA;
    }

    @Override
    public void atualizarView() {
        atividadeView.setAtividades(service.listarPorAtivo());
    }

    @Override
    public String editar() {
        service.editar(atividadeView.getAtividade());
        atualizarView();
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_EDICAO);
        return TELA_CONSULTA;
    }

    @Override
    public String visualizar() {
        return TELA_EDICAO;
    }

    @Override
    public String excluir(EntidadeComum entidade) {
        service.excluir(entidade);
        atualizarView();
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_EXCLUSAO);
        return TELA_CONSULTA;
    }

    public AtividadeView getAtividadeView() {
        return atividadeView;
    }

    public void setAtividadeView(AtividadeView atividadeView) {
        this.atividadeView = atividadeView;
    }

}
