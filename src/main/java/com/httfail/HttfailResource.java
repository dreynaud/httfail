package com.httfail;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
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

    private Response respond(Integer status, String reason) {
        return Response.status(status).entity(reason).build();
    }

    @GET
    public Response get() { return respond(defaultStatus, defaultReason); }

    @GET
    @Path("/{http-status}")
    public Response get(@PathParam("http-status") Integer httpStatus) { return respond(httpStatus, defaultReason); }


    @POST
    public Response post() { return respond(defaultStatus, defaultReason); }

    @POST
    @Path("/{http-status}")
    public Response post(@PathParam("http-status") Integer httpStatus) { return respond(httpStatus, defaultReason); }


    @PUT
    public Response put() { return respond(defaultStatus, defaultReason); }

    @PUT
    @Path("/{http-status}")
    public Response put(@PathParam("http-status") Integer httpStatus) { return respond(httpStatus, defaultReason); }


    @DELETE
    public Response delete() { return respond(defaultStatus, defaultReason); }

    @DELETE
    @Path("/{http-status}")
    public Response delete(@PathParam("http-status") Integer httpStatus) { return respond(httpStatus, defaultReason); }


    @HEAD
    public Response head() { return respond(defaultStatus, defaultReason); }

    @HEAD
    @Path("/{http-status}")
    public Response head(@PathParam("http-status") Integer httpStatus) { return respond(httpStatus, defaultReason); }


    @OPTIONS
    public Response options() { return respond(defaultStatus, defaultReason); }

    @OPTIONS
    @Path("/{http-status}")
    public Response options(@PathParam("http-status") Integer httpStatus) { return respond(httpStatus, defaultReason); }
}