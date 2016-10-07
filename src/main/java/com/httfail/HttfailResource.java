package com.httfail;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/{http-status}")
//@Produces(MediaType.APPLICATION_JSON)
public class HttfailResource {
    public HttfailResource() {}

    @GET
    @Timed
    public Response sayHello(@PathParam("http-status") Optional<Integer> httpStatus) {
        if (!httpStatus.isPresent()) {
            throw new IllegalArgumentException("missing status");
        }
        return Response.status(httpStatus.get()).build();
    }
}