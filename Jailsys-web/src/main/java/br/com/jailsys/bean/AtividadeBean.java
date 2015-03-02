package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.service.AtividadeService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.AtividadeView;

@ManagedBean
@ViewScoped
public class AtividadeBean implements Serializable, AbstractBean<EntidadeComum> {

	private static final long serialVersionUID = 7961530823602276424L;

	@Inject
	private AtividadeService service;

	@Inject
	private AtividadeView atividadeView;
	
	private DualListModel<Atividade> atividadesDualList;
 
	public List<Atividade> listarItensAtivos() {
		if (atividadeView.getAtividades().isEmpty()) {
			this.atualizarView();
		}
		return atividadeView.getAtividades();
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Atividade.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		/*List<Atividade> atividadeASerVinculadas = atividadesDualList.getTarget();*/
		
		service.salvar(atividadeView.getAtividade());
		this.atualizarView();
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Atividade.MENSAGEM_CADASTRO);
		return Constantes.Atividade.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		atividadeView.setAtividades(service.listarItensAtivos());
	}

	public String editar() {
		service.editar(atividadeView.getAtividade());
		this.atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Atividade.MENSAGEM_EDICAO);
		return Constantes.Atividade.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Atividade.TELA_VISUALIZAR;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		service.excluir(entidade);
		this.atualizarView();
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Atividade.MENSAGEM_EXCLUSAO);
		return Constantes.Atividade.TELA_CONSULTA;
	}

	@Override
	public boolean isVisualizar() {
		return Boolean.parseBoolean(FacesUtil
				.getRequestParameter("isVisualizar"));
	}

	public AtividadeView getAtividadeView() {
		return atividadeView;
	}

	public void setAtividadeView(AtividadeView atividadeView) {
		this.atividadeView = atividadeView;
	}

	public DualListModel<Atividade> getAtividadesDualList() {
		List<Atividade> atividadesDesvinculadas = service.listarItensAtivos();
		List<Atividade> atividadesVinculadas = new ArrayList<Atividade>();
		
		return new DualListModel<Atividade>(atividadesDesvinculadas, atividadesVinculadas);
		/*return atividadesDualList;*/
	}

	public void setAtividadesDualList(DualListModel<Atividade> atividadesDualList) {
		this.atividadesDualList = atividadesDualList;
	}
	
	public DualListModel<Atividade> atividadesDualListCadastro(){
		List<Atividade> atividadesDesvinculadas = service.listarItensAtivos();
		List<Atividade> atividadesVinculadas = new ArrayList<Atividade>();
		
		return new DualListModel<Atividade>(atividadesDesvinculadas, atividadesVinculadas);
	}
	
	public DualListModel<Atividade> atividadesDualListEdicao(){
		
		List<Atividade> atividadesDesvinculadas = service.listarDesvinculadas(atividadeView.getAtividade().getId());
		List<Atividade> atividadesVinculadas = service.listarVinculadas(atividadeView.getAtividade().getId());
		
		return new DualListModel<Atividade>(atividadesDesvinculadas, atividadesVinculadas);
	}
	
}
