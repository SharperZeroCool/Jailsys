package br.com.jailsys.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.jailsys.model.Funcionario;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.model.Preso;
import br.com.jailsys.qualifier.PessoaBean;
import br.com.jailsys.service.FuncionarioService;
import br.com.jailsys.service.PessoaService;
import br.com.jailsys.service.PresoService;
import br.com.jailsys.util.FacesUtil;

import com.google.common.base.Strings;

public class ProdutorPessoa {
	@Inject
	private PessoaService pessoaService;

	@Inject
	private FuncionarioService funcionarioService;

	@Inject
	private PresoService presoService;

	@Produces
	@PessoaBean
	public Pessoa produzirPessoa() {
		Pessoa entidade = new Pessoa();
		entidade.setAtivo(Boolean.TRUE);
		String idPessoa = FacesUtil.getRequestParameter("idPessoa");
		String idFuncionario = FacesUtil.getRequestParameter("idFuncionario");
		String idPreso = FacesUtil.getRequestParameter("idPreso");
		if (!Strings.isNullOrEmpty(idPessoa)) {
			Long idLong = new Long(idPessoa);
			entidade = (Pessoa) pessoaService.buscar(idLong);
		} else if (!Strings.isNullOrEmpty(idFuncionario)) {
			Long idLong = new Long(idFuncionario);
			entidade = (Funcionario) funcionarioService.buscar(idLong);
		} else if (!Strings.isNullOrEmpty(idPreso)) {
			Long idLong = new Long(idPreso);
			entidade = (Preso) presoService.buscar(idLong);
		}

		return entidade;
	}
}
