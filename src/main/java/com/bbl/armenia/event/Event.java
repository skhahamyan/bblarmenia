package com.bbl.armenia.event;

import com.bbl.armenia.tools.TextTool;
import com.bbl.armenia.user.Knowledge;
import com.bbl.armenia.user.Speaker;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Event implements Serializable {
    private static final long serialVersionUID = 7063838094872905770L;

    @Expose
    private Meeting meeting;
    @Expose
    private Speaker speaker;
    @Expose
    private Knowledge knowledge;

    public Event(Meeting meeting, Knowledge knowledge) {
        this.meeting = meeting;
        this.knowledge = knowledge;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
