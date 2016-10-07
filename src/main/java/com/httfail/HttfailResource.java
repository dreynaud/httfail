package com.httfail;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class HttfailResource {
    private final Integer defaultStatus;
    private final String defaultReason;

    public HttfailResource(Integer defaultStatus, String defaultReason) {
        this.defaultStatus = defaultStatus;
        this.defaultReason = defaultReason;
    }

    @GET
    public Response sayHello() {
        return Response.status(defaultStatus).entity(defaultReason).build();
    }

    @GET
    @Timed
    @Path("/{http-status}")
    public Response sayHello(@PathParam("http-status") Integer httpStatus) {
        return Response.status(httpStatus).entity(defaultReason).build();
    }
}