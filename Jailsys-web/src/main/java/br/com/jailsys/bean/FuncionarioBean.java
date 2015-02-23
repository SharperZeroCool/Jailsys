package br.com.jailsys.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.jailsys.bean.basic.AbstractBean;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Funcionario;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.service.FuncionarioService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.util.FacesUtil;
import br.com.jailsys.view.FuncionarioView;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements AbstractBean<EntidadeComum>,
		Serializable {

	private static final long serialVersionUID = -6274814536790349940L;

	@Inject
	FuncionarioService service;

	@Inject
	FuncionarioView funcionarioView;

	public List<Funcionario> listarItensAtivos() {
		if (funcionarioView.getFuncionarios().isEmpty()) {
			this.atualizarView();
		}
		return funcionarioView.getFuncionarios();
	}

	@Override
	public String prepararEdicao() {
		return Constantes.Funcionario.TELA_EDICAO;
	}

	@Override
	public String salvar() {
		service.salvar(funcionarioView.getFuncionario());
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Funcionario.MENSAGEM_CADASTRO);
		this.atualizarView();
		return Constantes.Funcionario.TELA_CONSULTA;
	}

	public String salvar(Pessoa pessoa) {
		this.populaItensDePessoa(pessoa);
		service.salvar(funcionarioView.getFuncionario());
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Funcionario.MENSAGEM_CADASTRO);
		this.atualizarView();
		return Constantes.Funcionario.TELA_CONSULTA;
	}

	@Override
	public void atualizarView() {
		funcionarioView.setFuncionarios(service.listarItensAtivos());
	}

	public String editar(Pessoa pessoa) {
		this.populaItensDePessoa(pessoa);
		service.editar(funcionarioView.getFuncionario());
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Funcionario.MENSAGEM_EDICAO);
		this.atualizarView();
		return Constantes.Funcionario.TELA_CONSULTA;
	}

	@Override
	public String visualizar() {
		return Constantes.Funcionario.TELA_VISUALIZAR;
	}

	@Override
	public String excluir(EntidadeComum funcionario) {
		service.excluir(funcionario);
		FacesUtil
				.mostrarMensagemSucesso(Constantes.Funcionario.MENSAGEM_EXCLUSAO);
		return Constantes.Funcionario.TELA_CONSULTA;
	}

	public FuncionarioView getFuncionarioView() {
		return funcionarioView;
	}

	public void setFuncionarioView(FuncionarioView funcionarioView) {
		this.funcionarioView = funcionarioView;
	}

	public void populaItensDePessoa(Pessoa pessoa) {
		Funcionario funcionario = funcionarioView.getFuncionario();
		funcionario.setId(pessoa.getId());
		funcionario.setNome(pessoa.getNome());
		funcionario.setCpf(pessoa.getCpf());
		funcionario.setEmail(pessoa.getEmail());
		funcionario.setDataNasc(pessoa.getDataNasc());
		funcionario.setCelular(pessoa.getCelular());
		funcionario.setAtivo(pessoa.isAtivo());
	}

}
