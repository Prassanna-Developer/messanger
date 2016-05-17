package org.prassannas.java.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.prassannas.java.rest.model.MyDate;


@Path("date")
public class DateResource {
	
	
	@GET
	@Path("/{mydate}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDate(@PathParam("mydate") MyDate myDate){
		return "GOT >> " + myDate;
	}

}
