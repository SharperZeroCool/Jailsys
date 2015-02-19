package br.com.jailsys.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jailsys.model.Pessoa;
import br.com.jailsys.qualifier.PessoaBean;

@Named
public class PessoaView implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 6345673282178638614L;

	@Inject
	@PessoaBean
	private Pessoa pessoa;

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
