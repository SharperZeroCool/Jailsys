package br.com.jailsys.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

public class EmailRunnable implements Runnable {

	private Thread thread;

	private String threadName;

	private String destinatario;

	private String assunto;

	private String conteudo;

	private static final Logger LOGGER = Logger.getLogger(EmailRunnable.class);

	public EmailRunnable(String name, String destinatario, String assunto,
			String conteudo) {
		threadName = name;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.conteudo = conteudo;
	}

	@Override
	public void run() {
		try {
			Context initialContext = new InitialContext();

			Session mailSession = (Session) initialContext
					.lookup("java:jboss/mail/outlook");

			String from = mailSession.getProperty("mail.smtp.user");

			MimeMessage message = new MimeMessage(mailSession);

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					destinatario));

			message.setSubject(assunto);

			message.setContent(conteudo, "text/plain");

			Transport.send(message);
		} catch (NamingException | MessagingException e) {
			LOGGER.error(e);
		}
	}

	public void enviarEmail() {
		if (thread == null) {
			thread = new Thread(this, threadName);
			thread.run();
		}
	}

}
