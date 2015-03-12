package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Visita;
import br.com.jailsys.service.VisitaService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.VisitaView;

@ManagedBean
@ViewScoped
public class VisitaBean implements AbstractBean<EntidadeComum>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4324131523064921216L;
	
	@Inject
	private VisitaService visitaService;
	
	@Inject
	private VisitaView visitaView;

	public List<Visita> listar() {
		if (visitaView.getVisitas().isEmpty()) {
			this.atualizarView();
		}
		return visitaView.getVisitas();
	}

	public String editar(){
		visitaService.editar(visitaView.getVisita());
		FacesUtil.mostrarMensagemSucesso(Constantes.Visita.MENSAGEM_EDICAO);
		return Constantes.Visita.TELA_CONSULTA;
	}
	
	@Override
	public String prepararEdicao() {
		return Constantes.Visita.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		visitaService.salvar(visitaView.getVisita());
		FacesUtil.mostrarMensagemSucesso(Constantes.Visita.MENSAGEM_CADASTRO);
		return Constantes.Visita.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		visitaView.setVisitas(visitaService.listarVisitas());
	}

	@Override
	public String visualizar() {
		return Constantes.Visita.TELA_VISUALIZAR;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		visitaService.excluir(entidade);
		return Constantes.Visita.TELA_CONSULTA;
	}

	@Override
	public boolean isVisualizar() {
		return Boolean.parseBoolean(FacesUtil
				.getRequestParameter("isVisualizar"));
	}
	
	//GETTERS E SETTERS
	public VisitaView getVisitaView() {
		return visitaView;
	}

	public void setVisitaView(VisitaView visitaView) {
		this.visitaView = visitaView;
	}

	
}
