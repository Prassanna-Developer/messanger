package org.prassannas.java.rest.client;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.prassannas.messenger.model.Message;

public class InvocationDemoClass {

	public static void main(String[] args) {
System.out.println("InvocationDemoClass.main()");
		
		Invocation builder = prepareMessageForYear(2016);
		Response invoke = builder.invoke();
		System.out.println(invoke.readEntity(Message.class).getCreated());

	}

	private static Invocation prepareMessageForYear(int year) {
		Client client = ClientBuilder.newClient();
		 
		WebTarget baseTarget = client
				.target("http://localhost:8080/advanced-jaxrs_01/");
		WebTarget rootTarget = baseTarget.path("root");
		WebTarget messageTarget = rootTarget.path("messages/1");
		
		
		return messageTarget.
		queryParam("year", year).
		request(MediaType.APPLICATION_JSON).buildGet();
	}

}
