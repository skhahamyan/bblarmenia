package com.bbl.armenia.ws;

import com.bbl.armenia.authentication.Secured;
import com.bbl.armenia.queries.*;
import com.bbl.armenia.tools.InjectionTool;
import com.bbl.armenia.user.Speaker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("speaker")
public class SpeakerService {
    QueryService<Speaker> queryService = InjectionTool.USER.getInstance(QueryService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSpeakers() {
        return "Got it !";
    }

    @POST
    @Secured
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public int createSpeaker(Speaker speaker) {
        queryService.create(speaker);
        return CREATED.getStatusCode();
    }

    @PUT
    @Secured
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public int updateSpeaker(@PathParam("id") Long id, Speaker speaker) {
        if (speaker.validationFails()) {
            return BAD_REQUEST.getStatusCode();
        }

        queryService.update(id, speaker);
        return OK.getStatusCode();
    }

    @DELETE
    @Secured
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public int deleteSpeaker(@PathParam("id") Long id) {
        queryService.delete(id);
        return OK.getStatusCode();
    }
}
