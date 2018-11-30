package com.bbl.armenia.service;

import com.bbl.armenia.queries.KnowledgeQuery;
import com.bbl.armenia.queries.SpeakerQuery;
import com.bbl.armenia.server.Injection;
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

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Singleton
@Path("speaker")
public class SpeakerService {
    private final SpeakerQuery speakerQuery = Injection.getInstance(SpeakerQuery.class);
    private final KnowledgeQuery knowledgeQuery = Injection.getInstance(KnowledgeQuery.class);

    public SpeakerService() {
        // Default constructor
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSpeakers() {
        return speakerQuery.getAll().toString();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSpeakerById(@PathParam("id") Long id) {
        return speakerQuery.getById(id).toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createSpeaker(SpeakerRequest speakerRequest) {
        try {
            speakerQuery.create(speakerRequest);
        } catch (Exception e) {
            return BAD_REQUEST.getStatusCode();
        }

        return CREATED.getStatusCode();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateSpeaker(SpeakerRequest speakerRequest) {
        try {
            speakerQuery.update(speakerRequest);
        } catch (Exception e) {
            return BAD_REQUEST.getStatusCode();
        }

        return OK.getStatusCode();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int deleteSpeaker(@PathParam("id") Long id) {
        speakerQuery.delete(id);
        return OK.getStatusCode();
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
    @Path("/knowledge")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createKnowledge(KnowledgeRequest knowledgeRequest) {
        try {
            knowledgeQuery.create(knowledgeRequest);
        } catch (Exception e) {
            return BAD_REQUEST.getStatusCode();
        }

        return CREATED.getStatusCode();
    }
}
