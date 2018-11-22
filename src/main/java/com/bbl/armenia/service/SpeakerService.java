package com.bbl.armenia.service;

import com.bbl.armenia.authentication.Secured;
import com.bbl.armenia.queries.PurgeOperation;
import com.bbl.armenia.queries.WriteOperation;
import com.bbl.armenia.tools.User;
import com.bbl.armenia.user.Speaker;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.Response.Status.*;

@Singleton
@Path("speaker")
public class SpeakerService {
    private WriteOperation<Speaker> writeOperation;
    private PurgeOperation purgeOperation;

    public SpeakerService() {
        // Test needs default constructor
    }

    @Inject
    public SpeakerService(@User WriteOperation writeOperation, @User PurgeOperation purgeOperation) {
        this.writeOperation = writeOperation;
        this.purgeOperation = purgeOperation;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSpeakers() {
        return "Got it !";
    }

    @POST
    @Secured
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createSpeaker(Speaker speaker) {
        writeOperation.create(speaker);
        return CREATED.getStatusCode();
    }

    @PUT
    @Secured
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateSpeaker(@PathParam("id") Long id, Speaker speaker) {
        if (speaker.validationFails()) {
            return BAD_REQUEST.getStatusCode();
        }

        writeOperation.update(id, speaker);
        return OK.getStatusCode();
    }

    @DELETE
    @Secured
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int deleteSpeaker(@PathParam("id") Long id) {
        purgeOperation.delete(id);
        return OK.getStatusCode();
    }
}
