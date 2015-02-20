package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.enums.TipoPessoa;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.service.PessoaService;
import br.com.jailsys.util.Constantes;
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

	private List<SelectItem> paginas;
	
	private String tipoPessoa;

	@PostConstruct
	public void preenchePaginas() {
		paginas = new ArrayList<SelectItem>();
		for (TipoPessoa tipo : TipoPessoa.values()) {
			paginas.add(new SelectItem(tipo.getPagina(), FacesUtil
					.getMessage(tipo.getLabel())));
		}
	}

	public List<Pessoa> listar() {
		if (pessoaView.getPessoas().isEmpty())
			pessoaView.setPessoas(service.listar());
		return pessoaView.getPessoas();
	}

	public List<Pessoa> listarItensAtivos() {
		if (pessoaView.getPessoas().isEmpty())
			this.atualizarView();
		return pessoaView.getPessoas();
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Pessoa.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		service.salvar(pessoaView.getPessoa());
		this.atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Pessoa.MENSAGEM_CADASTRO);
		return Constantes.Pessoa.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		pessoaView.setPessoas(service.listarItensAtivos());
	}

	@Override
	public String editar() {
		service.editar(pessoaView.getPessoa());
		this.atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Pessoa.MENSAGEM_EDICAO);
		return Constantes.Pessoa.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Pessoa.TELA_EDICAO;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		service.excluir(entidade);
		this.atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Pessoa.MENSAGEM_EXCLUSAO);
		return Constantes.Pessoa.TELA_CONSULTA;
	}

	public List<SelectItem> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<SelectItem> paginas) {
		this.paginas = paginas;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public PessoaView getPessoaView() {
		return pessoaView;
	}

	public void setPessoaView(PessoaView pessoaView) {
		this.pessoaView = pessoaView;
	}
	
	public boolean isFuncionario(){
		return Constantes.Pessoa.PAGINA_FUNCIONARIO.equals(tipoPessoa);
	}

}
