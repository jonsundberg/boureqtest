package com.bouvet.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bouvet.service.ImageService;
import com.codahale.metrics.annotation.Timed;

@Path("/image")
@Produces(MediaType.APPLICATION_JSON)
public class ImageResource {

	
	@GET
    @Timed
    public Response get() {
        try {
            return Response.ok(ImageService.fetchFromBouvet()).build();
        } catch (final Exception e) {
        	e.printStackTrace();
            return Response.serverError().entity(e.getMessage()).build();
        }
	}
}
