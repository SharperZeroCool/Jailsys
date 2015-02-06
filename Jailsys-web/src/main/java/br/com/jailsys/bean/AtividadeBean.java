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
import br.com.jailsys.view.AtividadeView;

@ManagedBean
@ViewScoped
public class AtividadeBean implements Serializable, AbstractBean<EntidadeComum> {

    private static final long serialVersionUID = 7961530823602276424L;

    @Inject
    private AtividadeService service;

    @Inject
    private AtividadeView atividadeView;

    public List<Atividade> listar() {
        return service.listar();
    }

    @Override
    public String prepararInclusao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String prepararEdicao() {
        // TODO Auto-generated method stub
        return "atividadeEdicao";
    }

    @Override
    public String salvar() {
        service.salvar(atividadeView.getAtividade());
        atualizarView();
        return "atividadeConsulta";
    }

    @Override
    public void atualizarView() {
        atividadeView.setAtividades(service.listar());
    }

    @Override
    public String editar() {
        service.editar(atividadeView.getAtividade());
        atualizarView();
        return "atividadeConsulta";
    }

    @Override
    public String visualizar() {
        return "atividadeEdicao";
    }

    @Override
    public String excluir(EntidadeComum entidade) {
        service.excluir(entidade);
        atualizarView();
        return "atividadeConsulta";
    }

    public AtividadeView getAtividadeView() {
        return atividadeView;
    }

    public void setAtividadeView(AtividadeView atividadeView) {
        this.atividadeView = atividadeView;
    }

}
