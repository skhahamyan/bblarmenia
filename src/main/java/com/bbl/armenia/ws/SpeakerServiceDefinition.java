package com.bbl.armenia.ws;

import com.bbl.armenia.authentication.Secured;
import com.bbl.armenia.user.Speaker;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface SpeakerServiceDefinition {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String getAllSpeakers();

    @POST
    @Secured
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    int createSpeaker(Speaker speaker);

    @PUT
    @Secured
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    int updateSpeaker(@PathParam("id") Long id, Speaker speaker);

    @DELETE
    @Secured
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    int deleteSpeaker(@PathParam("id") Long id);
}
