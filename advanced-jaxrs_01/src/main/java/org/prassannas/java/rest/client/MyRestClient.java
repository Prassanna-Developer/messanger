package org.prassannas.java.rest.client;


import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.prassannas.messenger.model.Message;


public class MyRestClient {

	public static void main(String[] args) {
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs_01/");
		
		WebTarget rootTarget = baseTarget.path("root");
		
		
		WebTarget messageTarget = rootTarget.path("messages");
		
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		
		 
		String firstMsg = singleMessageTarget.
		resolveTemplate("messageId", "1").
		request(MediaType.APPLICATION_JSON).
		get(Message.class).getMessage();
		
		
		
		String secondMsg = singleMessageTarget.
				resolveTemplate("messageId", "2").
				request(MediaType.APPLICATION_JSON).
				get(Message.class).getMessage();
		
		System.out.println(firstMsg  + ".." + secondMsg);
		
		// Post request
		System.out.println("-----------------------------------------------------");
		Message newMessage = new Message(50, "New Message using Jersey", "prassannas");
		
		
		Response post = messageTarget.
		request(MediaType.APPLICATION_JSON).
		post(Entity.json(newMessage));
		System.out.println(post.readEntity(Message.class).getMessage());
	}

}
