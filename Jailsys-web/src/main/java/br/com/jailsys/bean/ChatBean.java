package br.com.jailsys.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import br.com.jailsys.util.UtilitarioSeguranca;

import com.google.common.base.Strings;

@ManagedBean
@ViewScoped
public class ChatBean implements Serializable {

	private static final long serialVersionUID = 4735554820591327612L;

	private final EventBus eventBus = EventBusFactory.getDefault().eventBus();

	@ManagedProperty("#{chatUsers}")
	private ChatUsers users;

	private String globalMessage;

	private String username;

	private boolean loggedIn;

	private final static String CHANNEL = "/{room}/";

	public ChatUsers getUsers() {
		return users;
	}

	public void setUsers(ChatUsers users) {
		this.users = users;
	}

	public String getGlobalMessage() {
		return globalMessage;
	}

	public void setGlobalMessage(String globalMessage) {
		this.globalMessage = globalMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void sendGlobal() {
		if (!Strings.isNullOrEmpty(globalMessage)) {
			eventBus.publish(CHANNEL + "*", username + ": " + globalMessage);
			globalMessage = null;
		}
	}

	@PostConstruct
	public void login() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		RequestContext.getCurrentInstance().update("form");
		username = UtilitarioSeguranca.getUsuarioLogado();
		if (!Strings.isNullOrEmpty(username)) {
			users.add(username);
			requestContext.execute("PF('subscriber').connect('/" + username
					+ "')");
			loggedIn = true;
		}
	}

	@PreDestroy
	public void disconnect() {
		// remove user and update ui
		users.remove(username);
		RequestContext.getCurrentInstance().update("form");

		// push leave information
		eventBus.publish(CHANNEL + "*", username + " saiu do chat.");

		// reset state
		loggedIn = false;
		username = null;
	}
}