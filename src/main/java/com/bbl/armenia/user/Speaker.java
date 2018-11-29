package com.bbl.armenia.user;

import com.bbl.armenia.company.Company;
import com.bbl.armenia.queries.SpeakerQuery;
import com.bbl.armenia.server.Injection;
import com.bbl.armenia.tools.TextTool;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Speaker implements Serializable {
    private static final long serialVersionUID = 1722348904803550083L;

    private final SpeakerQuery speakerQuery = Injection.getInstance(SpeakerQuery.class);

    @Expose
    private Long id;
    @Expose
    private User user;
    @Expose
    private List<Knowledge> knowledges;
    @Expose
    private Company company;

    public Speaker() {
        // Default constructor needed by REST API
    }

    public Speaker(User user) {
        this.user = user;
        this.knowledges = new ArrayList<>();
    }

    public Speaker(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    boolean isSpeaker() {
        return !knowledges.isEmpty();
    }

    public List<Knowledge> getKnowledges() {
        return knowledges;
    }

    public Company getCompany() {
        return company;
    }

    public void create() throws Exception {
        if (validationFails()) {
            throw new Exception();
        }

        speakerQuery.create(this);
    }

    public void update() throws Exception {
        if (validationFails()) {
            throw new Exception();
        }

        speakerQuery.update(this);
    }

    public void delete() {
        speakerQuery.delete(id);
    }

    public void addKnowledge() throws Exception {
        if (knowledges.size() < 1) {
            throw new Exception();
        }

        for (Knowledge knowledge : knowledges) {
            knowledge.create(id);
        }
    }

    private boolean validationFails() {
        return Validation.fails(this);
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
