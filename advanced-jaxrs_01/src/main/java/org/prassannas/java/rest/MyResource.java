package org.prassannas.java.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("test")
public class MyResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest(){
		count = count+1;
		return "TEST" + ".. This method was called > " + count + " time(s)";
	}
	

}
