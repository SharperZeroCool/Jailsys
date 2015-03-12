package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.enums.TipoPessoa;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Funcionario;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.service.AtividadeService;
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

	@Inject
	private AtividadeService atividadeService;

	private String tipoPessoa;

	@PostConstruct
	public void preenchePaginas() {
		paginas = new ArrayList<SelectItem>();
		for (TipoPessoa tipo : TipoPessoa.values()) {
			paginas.add(new SelectItem(tipo.getPagina(), FacesUtil
					.getMessage(tipo.getLabel())));
		}
	}

	public List<Pessoa> listarItensAtivos() {
		if (pessoaView.getPessoas().isEmpty())
			this.atualizarView();
		return pessoaView.getPessoas();
	}
	
	public List<Pessoa> listarVisitantes(){
		return service.listarVisitantes();
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

	public String editar() {
		service.editar(pessoaView.getPessoa());
		this.atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Pessoa.MENSAGEM_EDICAO);
		return Constantes.Pessoa.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Pessoa.TELA_VISUALIZAR;
	}

	@Override
	public String excluir(EntidadeComum entidade) {
		service.excluir(entidade);
		this.atualizarView();
		FacesUtil.mostrarMensagemSucesso(Constantes.Pessoa.MENSAGEM_EXCLUSAO);
		return Constantes.Pessoa.TELA_CONSULTA;
	}

	@Override
	public boolean isVisualizar() {
		return Boolean.parseBoolean(FacesUtil
				.getRequestParameter("isVisualizar"));
	}

	public boolean isFuncionario() {
		return Constantes.Pessoa.PAGINA_FUNCIONARIO.equals(tipoPessoa)
				|| pessoaView.getPessoa() instanceof Funcionario;
	}

	public void getPickListAtividade() {
		List<Atividade> source = atividadeService.listarItensAtivos();
		List<Atividade> target = new ArrayList<Atividade>();
		pessoaView.setAtividadesDualList(new DualListModel<Atividade>(source,
				target));
	}

	public void getPickListAtividadePorPessoaId() {
		List<Atividade> source = atividadeService
				.listarDesvinculadas(pessoaView.getPessoa());
		List<Atividade> target = pessoaView.getPessoa().getAtividades();
		pessoaView.setAtividadesDualList(new DualListModel<Atividade>(source,
				target));
	}

	public void setarAtividades(TransferEvent event) {
		pessoaView.getPessoa().setAtividades(
				pessoaView.getAtividadesDualList().getTarget());
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

}
