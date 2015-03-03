package br.com.jailsys.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

public class Interceptador {
	@AroundInvoke
	public Object interceptador(InvocationContext ic) throws Exception {
		String classe = ic.getTarget().getClass().getName();
		String method = ic.getMethod().getName();
		Logger LOGGER = Logger.getLogger(ic.getTarget().getClass());
		LOGGER.info("Accessando:" + classe + "(" + method + ")");
		try {
			Object result = ic.proceed();
			LOGGER.info("Acesso realizado com sucesso!");
			return result;
		} catch (Exception e) {
			LOGGER.error("Ocorreu um erro no servidor!");
			throw e;
		}
	}
}
