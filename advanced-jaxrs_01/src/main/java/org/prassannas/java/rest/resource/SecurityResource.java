package org.prassannas.java.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("secured")
public class SecurityResource {
	
	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN)
	public String secureTest(){
		return "This API is secured";
	}
}
