package com.bbl.armenia.service;

import com.bbl.armenia.queries.KnowledgeQuery;
import com.bbl.armenia.queries.SpeakerQuery;
import com.bbl.armenia.server.Injection;
import com.google.inject.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @GET
    @Path("/{id}/include-knowledges")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSpeakerByIdWithKnowledges(@PathParam("id") Long id) {
        return speakerQuery.getByIdWithKnowledges(id).toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createSpeaker(SpeakerRequest speakerRequest) {
        speakerQuery.create(speakerRequest);
        return CREATED.getStatusCode();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateSpeaker(SpeakerRequest speakerRequest) {
        speakerQuery.update(speakerRequest);
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
    @Path("/{speakerId}/knowledge")
    @Produces(MediaType.APPLICATION_JSON)
    public String getKnowledgesBySpeaker(@PathParam("speakerId") Long speakerId) {
        return knowledgeQuery.getBySpeakerId(speakerId).toString();
    }

    @POST
    @Path("/knowledge")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int createKnowledge(KnowledgeRequest knowledgeRequest) {
        knowledgeQuery.create(knowledgeRequest);
        return CREATED.getStatusCode();
    }

    @PUT
    @Path("/knowledge")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateKnowledge(KnowledgeRequest knowledgeRequest) {
        knowledgeQuery.update(knowledgeRequest);
        return OK.getStatusCode();
    }

    @DELETE
    @Path("/knowledge/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int deleteKnowledge(@PathParam("id") Long id) {
        knowledgeQuery.delete(id);
        return OK.getStatusCode();
    }
}
