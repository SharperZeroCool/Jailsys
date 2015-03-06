package br.com.jailsys.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import br.com.jailsys.DAO.AmbienteDAO;
import br.com.jailsys.DAO.AtividadeDAO;
import br.com.jailsys.DAO.FuncionarioDAO;
import br.com.jailsys.DAO.GenericDAO;
import br.com.jailsys.DAO.PessoaDAO;
import br.com.jailsys.DAO.PresoDAO;
import br.com.jailsys.DAO.UsuarioDAO;
import br.com.jailsys.model.Ambiente;
import br.com.jailsys.model.Atividade;
import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.model.Funcionario;
import br.com.jailsys.model.Pessoa;
import br.com.jailsys.model.Preso;
import br.com.jailsys.model.Usuario;

public class PesquisaService {

	@Inject
	AmbienteDAO ambienteDao;

	@Inject
	AtividadeDAO atividadeDao;

	@Inject
	FuncionarioDAO funcionarioDao;

	@Inject
	PessoaDAO pessoaDao;

	@Inject
	PresoDAO presoDao;

	@Inject
	UsuarioDAO usuarioDao;

	public Set<EntidadeComum> getResultadoPesquisa(String termoPesquisa) {
		Set<EntidadeComum> resultados = new LinkedHashSet<EntidadeComum>();
		resultados.addAll(getResultadoPesquisaAmbiente(termoPesquisa));
		resultados.addAll(getResultadoPesquisaAtividade(termoPesquisa));
		resultados.addAll(getResultadoPesquisaFuncionario(termoPesquisa));
		resultados.addAll(getResultadoPesquisaPreso(termoPesquisa));
		resultados.addAll(getResultadoPesquisaPessoa(termoPesquisa));
		resultados.addAll(getResultadoPesquisaUsuario(termoPesquisa));
		return resultados;
	}

	private List<EntidadeComum> getResultadoPesquisaAmbiente(
			String termoPesquisa) {
		return getResultadoPesquisaGenerica(ambienteDao,
				Ambiente.class.getDeclaredFields(), termoPesquisa);
	}

	private List<EntidadeComum> getResultadoPesquisaAtividade(
			String termoPesquisa) {
		return getResultadoPesquisaGenerica(atividadeDao,
				Atividade.class.getDeclaredFields(), termoPesquisa);
	}

	private List<EntidadeComum> getResultadoPesquisaFuncionario(
			String termoPesquisa) {
		return getResultadoPesquisaGenerica(funcionarioDao,
				Funcionario.class.getDeclaredFields(), termoPesquisa);
	}

	private List<EntidadeComum> getResultadoPesquisaPessoa(String termoPesquisa) {
		return getResultadoPesquisaGenerica(pessoaDao,
				Pessoa.class.getDeclaredFields(), termoPesquisa);
	}

	private List<EntidadeComum> getResultadoPesquisaPreso(String termoPesquisa) {
		return getResultadoPesquisaGenerica(presoDao,
				Preso.class.getDeclaredFields(), termoPesquisa);
	}

	private List<EntidadeComum> getResultadoPesquisaUsuario(String termoPesquisa) {
		return getResultadoPesquisaGenerica(usuarioDao,
				Usuario.class.getDeclaredFields(), termoPesquisa);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<EntidadeComum> getResultadoPesquisaGenerica(GenericDAO dao,
			Field[] fields, String termoPesquisa) {
		List<String> atributos = new ArrayList<String>();
		for (Field field : fields) {
			if (!Modifier.isStatic(field.getModifiers())
					&& (field.getType().equals(String.class) || field.getType()
							.equals(Date.class))) {
				atributos.add(field.getName());
			}
		}
		return dao.listarPorLike(atributos, termoPesquisa);
	}

}
