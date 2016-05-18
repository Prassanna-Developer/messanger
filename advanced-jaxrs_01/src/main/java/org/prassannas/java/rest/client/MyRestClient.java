package org.prassannas.java.rest.client;


import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;


public class MyRestClient {

	public static void main(String[] args) {
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		
		Response response = client.target("http://localhost:8080/advanced-jaxrs_01/root/today").request().get();
		System.out.println(response); 
	}

}
