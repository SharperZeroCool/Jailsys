package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.service.AmbienteService;
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

	public List<Ambiente> listar() {
		if (ambienteView.getAmbientes().isEmpty()) {
			ambienteView.setAmbientes(service.listar());
		}
		return ambienteView.getAmbientes();
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Ambiente.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		service.salvar(ambienteView.getAmbiente());
		FacesUtil.mostrarMensagemSucesso(Constantes.Ambiente.MENSAGEM_CADASTRO);
		this.atualizarView();
		return Constantes.Ambiente.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		ambienteView.setAmbientes(service.listar());

	}

	public String editar() {
		service.editar(ambienteView.getAmbiente());
		FacesUtil.mostrarMensagemSucesso(Constantes.Ambiente.MENSAGEM_EDICAO);
		return Constantes.Ambiente.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Ambiente.TELA_EDICAO;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		service.excluir(entidade);
		atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Ambiente.MENSAGEM_EXCLUSAO);
		return Constantes.Ambiente.TELA_CONSULTA;
	}

	public AmbienteView getAmbienteView() {
		return ambienteView;
	}

	public void setAmbienteView(AmbienteView ambienteView) {
		this.ambienteView = ambienteView;
	}

}
