package com.packtpub.Microservices.openliberty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("temperature")
public class TemperatureResource {

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAverageTemperature() {
    Temperature temperature = new Temperature();
    temperature.setTemperature(35D);
    temperature.setTemperatureScale("CELSIUS");
    return Response.ok(temperature).build();
    }

}
