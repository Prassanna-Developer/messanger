package org.prassannas.java.rest.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("testDate")
public class MBWDateResource {
	
	
	@GET
	@Produces("textShortDate")
	public Date getActualDate(){
		return Calendar.getInstance().getTime();
	}

}
