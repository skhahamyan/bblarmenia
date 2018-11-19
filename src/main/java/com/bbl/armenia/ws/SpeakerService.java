package com.bbl.armenia.ws;

import com.bbl.armenia.user.Speaker;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("speaker")
public class SpeakerService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSpeakers() {
        return "Got it !";
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSpeaker(Speaker speaker) {
        speaker.create();
        return Response.status(201).entity(Response.ok()).build();
    }
}
