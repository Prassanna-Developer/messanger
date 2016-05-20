package org.prassannas.java.rest.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecuredFilter implements ContainerRequestFilter {
	
	public final static String AUTH_KEY = "Authorization";

	public void filter(ContainerRequestContext requestContext) throws IOException {
		// first check its only for secured path
		if(requestContext.getUriInfo().getPath().contains("secured")){
			
			List<String> list = requestContext.getHeaders().get(AUTH_KEY);
			if (list!=null && list.size() > 0) {
				String headerValue = list.get(0);
				String actualheader = headerValue.replaceFirst("Basic ", "");
				String decodedString = Base64.decodeAsString(actualheader);
				StringTokenizer tokenizer = new StringTokenizer(decodedString,
						":");
				String userName = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if (userName.equals("user") && password.equals("pwd")) {
					return;
				}
			}
			
		}
		
		Response unauthorizedResponse = Response.status(Response.Status.UNAUTHORIZED).
							entity("Unautoroze to see this API").
								build();
		
		requestContext.abortWith(unauthorizedResponse);
	}

}
