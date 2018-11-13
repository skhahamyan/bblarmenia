package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Speaker implements Serializable {
    private static final long serialVersionUID = 1722348904803550083L;

    private User user;
    private List<Knowledge> knowledges;

    public Speaker(User user) {
        this.user = user;
        this.knowledges = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void addKnowledge(Knowledge knowledge) {
        knowledges.add(knowledge);
    }

    public boolean isSpeaker() {
        return !knowledges.isEmpty();
    }

    public List<Knowledge> getKnowledges() {
        return knowledges;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
