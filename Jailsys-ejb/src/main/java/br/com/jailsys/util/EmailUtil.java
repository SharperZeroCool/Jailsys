package br.com.jailsys.util;

import com.google.common.base.Strings;

public class EmailUtil {

	private static final String THREAD_NAME = "Envio De Email Para:";

	public static void enviarEmail(String destinatario, String assunto,
			String conteudo) {
		if (!Strings.isNullOrEmpty(destinatario)) {
			EmailRunnable runnable = new EmailRunnable(
					THREAD_NAME.concat(destinatario), destinatario, assunto,
					conteudo);
			runnable.enviarEmail();
		}

	}
}
