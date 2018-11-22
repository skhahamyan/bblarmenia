package com.bbl.armenia.service;

import com.google.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("event")
public class EventService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return "My event";
    }
}
