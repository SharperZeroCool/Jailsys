package br.com.jailsys.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.spi.CDI;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.jailsys.model.EntidadeComum;
import br.com.jailsys.service.PesquisaService;
import br.com.jailsys.util.Constantes;
import br.com.jailsys.view.PesquisaView;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PesquisaBean {

	@Inject
	PesquisaService service;

	@Inject
	PesquisaView pesquisaView;

	private final Class[] NENHUM_PARAMETRO = new Class[0];

	private final String METODO_VISUALIZAR = "visualizar";

	private final String METODO_PREPARAR_EDICAO = "prepararEdicao";

	private final String METODO_EXCLUIR = "excluir";

	private final String PACOTE_BEAN = "br.com.jailsys.bean.";

	private final String BEAN = "Bean";

	public String listarPorLike() {
		List<EntidadeComum> entidades = new ArrayList<EntidadeComum>();
		String termoPesquisa = pesquisaView.getTermoPesquisa();
		pesquisaView.setTermoPesquisa(null);
		entidades.addAll(service.getResultadoPesquisa(termoPesquisa));
		pesquisaView.setResultado(entidades);
		return Constantes.Pesquisa.TELA_RESULTADO;
	}

	public String visualizar(EntidadeComum entidade) throws Exception {
		Class classeBean = getClasseBean(entidade.getTipo());
		Object instanciaBean = getInstanciaBean(classeBean);
		return executaMetodoViaReflection(classeBean, instanciaBean,
				METODO_VISUALIZAR, NENHUM_PARAMETRO);
	}

	public String prepararEdicao(EntidadeComum entidade) throws Exception {
		Class classeBean = getClasseBean(entidade.getTipo());
		Object instanciaBean = getInstanciaBean(classeBean);
		return executaMetodoViaReflection(classeBean, instanciaBean,
				METODO_PREPARAR_EDICAO, NENHUM_PARAMETRO);
	}

	public String excluir(EntidadeComum entidade) throws Exception {
		Class classeBean = getClasseBean(entidade.getTipo());
		Class[] classeEntidade = { entidade.getClass().getSuperclass() };
		Object instanciaBean = getInstanciaBean(classeBean);
		return executaMetodoViaReflection(classeBean, instanciaBean,
				METODO_EXCLUIR, classeEntidade, entidade);
	}

	public PesquisaView getPesquisaView() {
		return pesquisaView;
	}

	public void setPesquisaView(PesquisaView pesquisaView) {
		this.pesquisaView = pesquisaView;
	}

	private Class getClasseBean(String nomeEntidade)
			throws ClassNotFoundException {
		return Class.forName(PACOTE_BEAN + nomeEntidade + BEAN);
	}

	private Object getInstanciaBean(Class classeBean) {
		return CDI.current().select(classeBean).get();
	}

	private String executaMetodoViaReflection(Class classeBean,
			Object instanciaBean, String nomeMetodo, Class[] classeParametro,
			Object... instanciaParametro) throws Exception {
		Method metodo = classeBean.getDeclaredMethod(nomeMetodo,
				classeParametro);
		return (String) metodo.invoke(instanciaBean, instanciaParametro);
	}

}
