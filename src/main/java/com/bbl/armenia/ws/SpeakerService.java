package com.bbl.armenia.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("speaker")
public class SpeakerService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return "Got it !";
    }
}
