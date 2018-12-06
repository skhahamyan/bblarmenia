package com.bbl.armenia.service;

import com.bbl.armenia.queries.EventQuery;
import com.bbl.armenia.server.Injection;
import com.google.inject.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Singleton
@Path("event")
public class EventService {
    private final EventQuery eventQuery = Injection.getInstance(EventQuery.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEvents() {
        return eventQuery.getAll().toString();
    }

    @GET
    @Path("/speaker/{speakerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEventsBySpeakerId(@PathParam("speakerId") Long speakerId) {
        return eventQuery.getAllBySpeakerId(speakerId).toString();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventById(@PathParam("id") Long id) {
        return eventQuery.getById(id).toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createEvent(EventRequest eventRequest) {
        eventQuery.create(eventRequest);
        return CREATED.getStatusCode();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateEvent(EventRequest eventRequest) {
        eventQuery.update(eventRequest);
        return OK.getStatusCode();
    }

    @PUT
    @Path("/{id}/accept")
    @Produces(MediaType.APPLICATION_JSON)
    public int acceptEvent(@PathParam("id") Long id) {
        eventQuery.accept(id);
        return OK.getStatusCode();
    }

    @PUT
    @Path("/{id}/cancel")
    @Produces(MediaType.APPLICATION_JSON)
    public int cancelEvent(@PathParam("id") Long id) {
        eventQuery.cancel(id);
        return OK.getStatusCode();
    }
}
