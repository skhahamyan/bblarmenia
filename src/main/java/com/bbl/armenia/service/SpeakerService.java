package com.bbl.armenia.service;

import com.bbl.armenia.queries.KnowledgeQuery;
import com.bbl.armenia.server.Injection;
import com.bbl.armenia.user.Speaker;
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
import java.util.Objects;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Singleton
@Path("speaker")
public class SpeakerService {
    private final KnowledgeQuery knowledgeQuery = Injection.getInstance(KnowledgeQuery.class);

    public SpeakerService() {
        // Test needs default constructor
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSpeakers() {
        return "Got it !";
    }

    @GET
    @Path("/knowledge")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllKnowledges() {
        return knowledgeQuery.getAll().toString();
    }

    @GET
    @Path("/knowledge/{speakerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getKnowledgesBySpeaker(@PathParam("speakerId") Long speakerId) {
        return knowledgeQuery.getBySpeakerId(speakerId).toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createSpeaker(Speaker speaker) {
        Objects.requireNonNull(speaker);

        try {
            speaker.create();
        } catch (Exception e) {
            return BAD_REQUEST.getStatusCode();
        }

        return CREATED.getStatusCode();
    }

    @POST
    @Path("/knowledge")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createKnowledge(Speaker speaker) {
        Objects.requireNonNull(speaker);
        Objects.requireNonNull(speaker.getKnowledges());

        try {
            speaker.addKnowledge();
        } catch (Exception e) {
            return BAD_REQUEST.getStatusCode();
        }

        return CREATED.getStatusCode();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateSpeaker(Speaker speaker) {
        Objects.requireNonNull(speaker);
        Objects.requireNonNull(speaker.getId());

        try {
            speaker.update();
        } catch (Exception e) {
            return BAD_REQUEST.getStatusCode();
        }

        return OK.getStatusCode();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int deleteSpeaker(@PathParam("id") Long id) {
        Objects.requireNonNull(id);
        Speaker deleteSpeaker = new Speaker(id);
        deleteSpeaker.delete();
        return OK.getStatusCode();
    }
}
