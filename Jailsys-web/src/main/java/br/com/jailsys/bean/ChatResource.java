package br.com.jailsys.bean;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.primefaces.push.EventBus;
import org.primefaces.push.RemoteEndpoint;
import org.primefaces.push.annotation.OnClose;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.OnOpen;
import org.primefaces.push.annotation.PathParam;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.annotation.Singleton;

import com.google.common.base.Strings;

@PushEndpoint("/{room}/{user}")
@Singleton
public class ChatResource {

	@PathParam("room")
	private String room;

	@PathParam("user")
	private String username;

	@Inject
	private ServletContext ctx;

	@OnOpen
	public void onOpen(RemoteEndpoint r, EventBus eventBus) {

		if (!Strings.isNullOrEmpty(username)) {

			eventBus.publish(
					room + "/*",
					new Message(String.format("%s entrou no chat '%s'",
							username, room), true));
		}
	}

	@OnClose
	public void onClose(RemoteEndpoint r, EventBus eventBus) {
		if (!Strings.isNullOrEmpty(username)) {

			ChatUsers users = (ChatUsers) ctx.getAttribute("chatUsers");
			users.remove(username);

			eventBus.publish(room + "/*",
					new Message(
							String.format("%s saiu da aplicação.", username),
							true));
		}
	}

	@OnMessage(decoders = { MessageDecoder.class }, encoders = { MessageEncoder.class })
	public Message onMessage(Message message) {
		return message;
	}

}