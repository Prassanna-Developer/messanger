package org.prassannas.java.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/newtest")
public class MyResource1 {

	@PathParam("pathParam")
	private String pathParamExample;
	@QueryParam("query")
	private String queryParamExample;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest() {
		return "TEST  >> " + pathParamExample + "..." + queryParamExample;
	}
}
