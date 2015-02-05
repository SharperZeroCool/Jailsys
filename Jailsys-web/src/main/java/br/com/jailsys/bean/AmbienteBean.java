package br.com.jailsys.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.service.AmbienteService;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.AmbienteView;

@ManagedBean
@ViewScoped
public class AmbienteBean implements AbstractBean<EntidadeComum>, Serializable {

    private static final long serialVersionUID = 8045387637462936833L;

    @Inject
    private AmbienteService ambienteService;

    @Inject
    private AmbienteView ambienteView;

    private final String TELA_CADASTRO = "ambienteCadastro.xhtml";
    private final String TELA_CONSULTA = "ambienteConsulta.xhtml";
    private final String TELA_EDICAO = "ambienteEdicao.xhtml";
    private final String MENSAGEM_CADASTRO = "jailsysweb.ambiente.cadastro.sucesso";
    private final String MENSAGEM_EDICAO = "jailsysweb.ambiente.edicao.sucesso";
    private final String MENSAGEM_EXCLUSAO = "jailsysweb.ambiente.exclusao.sucesso";

    @Override
    public String salvar() {
        ambienteService.salvar(ambienteView.getAmbiente());
        FacesUtil.mostrarMensagemSucesso(MENSAGEM_CADASTRO);
        this.atualizarView();
        return TELA_CONSULTA;
    }

    @Override
    public void atualizarView() {
        // TODO Auto-generated method stub

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

    public AmbienteView getAmbienteView() {
        return ambienteView;
    }

    public void setAmbienteView(AmbienteView ambienteView) {
        this.ambienteView = ambienteView;
    }

}
