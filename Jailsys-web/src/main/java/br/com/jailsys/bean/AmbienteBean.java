package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.AfterBegin;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.service.AmbienteService;
import br.com.jailsys.service.AtividadeService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.AmbienteView;

@ManagedBean
@ViewScoped
public class AmbienteBean implements AbstractBean<EntidadeComum>, Serializable {

	private static final long serialVersionUID = 8045387637462936833L;

	@Inject
	private AmbienteService service;

	@Inject
	private AmbienteView ambienteView;
	
	@Inject
	private AtividadeService atividadeService;

	private DualListModel<Atividade> atividadesDualList;

	public List<Ambiente> listarItensAtivos() {
		if (ambienteView.getAmbientes().isEmpty()) {
			this.atualizarView();
		}
		return ambienteView.getAmbientes();
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Ambiente.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		setarAtividades();
		service.salvar(ambienteView.getAmbiente());
		FacesUtil.mostrarMensagemSucesso(Constantes.Ambiente.MENSAGEM_CADASTRO);
		this.atualizarView();
		return Constantes.Ambiente.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		ambienteView.setAmbientes(service.listarItensAtivos());

	}

	public String editar() {
		service.editar(ambienteView.getAmbiente());
		FacesUtil.mostrarMensagemSucesso(Constantes.Ambiente.MENSAGEM_EDICAO);
		return Constantes.Ambiente.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Ambiente.TELA_VISUALIZAR;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		service.excluir(entidade);
		atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Ambiente.MENSAGEM_EXCLUSAO);
		return Constantes.Ambiente.TELA_CONSULTA;
	}

	@Override
	public boolean isVisualizar() {
		return Boolean.parseBoolean(FacesUtil
				.getRequestParameter("isVisualizar"));
	}

	public AmbienteView getAmbienteView() {
		return ambienteView;
	}

	public void setAmbienteView(AmbienteView ambienteView) {
		this.ambienteView = ambienteView;
	}

	public void preparaView(){
		List<Atividade> source = atividadeService.listarItensAtivos();
        List<Atividade> target = new ArrayList<Atividade>();
        ambienteView.setAtividadesDualList(new DualListModel<Atividade>(source, target));
	}
	
	public DualListModel<Atividade> getAtividadesDualList() {
		return atividadesDualList;
	}
	
	public void setAtividadesDualList(
			DualListModel<Atividade> atividadesDualList) {
		this.atividadesDualList = atividadesDualList;
	}

	public DualListModel<Atividade> atividadesDualListEdicao() {
		atividadesDualList.setSource(atividadeService
				.listarDesvinculadas(ambienteView.getAmbiente().getId()));
		atividadesDualList.setTarget(atividadeService
				.listarVinculadas(ambienteView.getAmbiente().getId()));

		return atividadesDualList;
	}
	
	private void setarAtividades(){
		ambienteView.getAmbiente().setAtividades(ambienteView.getAtividadesDualList().getTarget());
	}
}
