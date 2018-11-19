package com.bbl.armenia.user;

import com.bbl.armenia.company.Company;
import com.bbl.armenia.server.Database;
import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.generated.tables.Speaker.SPEAKER;

public class Speaker implements Serializable {
    private static final long serialVersionUID = 1722348904803550083L;

    private User user;
    private List<Knowledge> knowledges;
    private Company company;

    public Speaker() {
    }

    public Speaker(User user) {
        this.user = user;
        this.knowledges = new ArrayList<>();
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

    public void create() {
        Identity identity = user.getIdentity();
        Database.getJOOQ().insertInto(SPEAKER, SPEAKER.FIRST_NAME, SPEAKER.LAST_NAME)
                .values(identity.getFirstName(), identity.getLastName())
                .execute();
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
