package br.com.jailsys.util;

import org.primefaces.json.JSONObject;
import org.primefaces.push.Encoder;

import br.com.jailsys.view.Message;

/**
 * A Simple {@link org.primefaces.push.Encoder} that decode a {@link Message}
 * into a simple JSON object.
 */
public final class MessageEncoder implements Encoder<Message, String> {

	public String encode(Message message) {
		return new JSONObject(message).toString();
	}
}