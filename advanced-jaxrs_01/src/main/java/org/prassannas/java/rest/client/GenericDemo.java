package org.prassannas.java.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.prassannas.messenger.model.Message;

public class GenericDemo {
	
	public static void main(String[] args) {
		System.out.println("GenericDemo.main()");
		
		Client client = ClientBuilder.newClient();
		 
		WebTarget baseTarget = client
				.target("http://localhost:8080/advanced-jaxrs_01/");
		WebTarget rootTarget = baseTarget.path("root");
		WebTarget messageTarget = rootTarget.path("messages");
		
		
		List<Message> list = messageTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Message>>(){});
		
		System.out.println(list);
	}

}
