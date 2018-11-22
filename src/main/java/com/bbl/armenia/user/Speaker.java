package com.bbl.armenia.user;

import com.bbl.armenia.company.Company;
import com.bbl.armenia.queries.SpeakerQuery;
import com.bbl.armenia.server.GuiceInjector;
import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Speaker implements Serializable {
    private static final long serialVersionUID = 1722348904803550083L;

    private SpeakerQuery speakerQuery = GuiceInjector.injector().getInstance(SpeakerQuery.class);
    private Long id;
    private User user;
    private List<Knowledge> knowledges;
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

    void addKnowledge(Knowledge knowledge) {
        knowledges.add(knowledge);
    }

    boolean isSpeaker() {
        return !knowledges.isEmpty();
    }

    List<Knowledge> getKnowledges() {
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

    private boolean validationFails() {
        return Validation.fails(this);
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
