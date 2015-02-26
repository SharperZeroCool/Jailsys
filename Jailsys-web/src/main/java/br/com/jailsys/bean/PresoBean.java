package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.model.Preso;
import br.com.jailsys.service.PresoService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.PresoView;

@ManagedBean
@ViewScoped
public class PresoBean implements AbstractBean<EntidadeComum>, Serializable {

	private static final long serialVersionUID = -8523743092556986021L;

	@Inject
	PresoService service;

	@Inject
	PresoView presoView;

	public List<Preso> listarItensAtivos() {
		if (presoView.getPresos().isEmpty()) {
			this.atualizarView();
		}
		return presoView.getPresos();
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Preso.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		service.salvar(presoView.getPreso());
		FacesUtil.mostrarMensagemSucesso(Constantes.Preso.MENSAGEM_CADASTRO);
		this.atualizarView();
		return Constantes.Preso.TELA_CONSULTA;
	}

	public String salvar(Pessoa pessoa) {
		this.populaItensDePessoa(pessoa);
		service.salvar(presoView.getPreso());
		FacesUtil.mostrarMensagemSucesso(Constantes.Preso.MENSAGEM_CADASTRO);
		this.atualizarView();
		return Constantes.Preso.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		presoView.setPresos(service.listarItensAtivos());

	}

	public String editar(Pessoa pessoa) {
		this.populaItensDePessoa(pessoa);
		service.editar(presoView.getPreso());
		FacesUtil.mostrarMensagemSucesso(Constantes.Preso.MENSAGEM_EDICAO);
		return Constantes.Preso.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Preso.TELA_VISUALIZAR;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		service.excluir(entidade);
		FacesUtil.mostrarMensagemSucesso(Constantes.Preso.MENSAGEM_EXCLUSAO);
		return Constantes.Preso.TELA_CONSULTA;
	}

	@Override
	public boolean isVisualizar() {
		return Boolean.parseBoolean(FacesUtil
				.getRequestParameter("isVisualizar"));
	}

	public void populaItensDePessoa(Pessoa pessoa) {
		Preso preso = presoView.getPreso();
		preso.setId(pessoa.getId());
		preso.setNome(pessoa.getNome());
		preso.setCpf(pessoa.getCpf());
		preso.setEmail(pessoa.getEmail());
		preso.setDataNasc(pessoa.getDataNasc());
		preso.setCelular(pessoa.getCelular());
		preso.setAtivo(pessoa.isAtivo());
	}

	public PresoView getPresoView() {
		return presoView;
	}

	public void setPresoView(PresoView presoView) {
		this.presoView = presoView;
	}

}
