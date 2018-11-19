package com.bbl.armenia.ws;

import com.bbl.armenia.user.Speaker;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

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
    public int createSpeaker(Speaker speaker) {
        speaker.create();
        return CREATED.getStatusCode();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public int updateSpeaker(@PathParam("id") Long id, Speaker speaker) {
        if (speaker.validationFails()) {
            return BAD_REQUEST.getStatusCode();
        }

        speaker.update(id);
        return OK.getStatusCode();
    }
}
