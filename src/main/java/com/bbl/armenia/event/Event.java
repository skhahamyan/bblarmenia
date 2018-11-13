package com.bbl.armenia.event;

import com.bbl.armenia.tools.TextTool;
import com.bbl.armenia.user.Speaker;

import java.io.Serializable;

public class Event implements Serializable {
    private static final long serialVersionUID = 7063838094872905770L;

    private Meeting meeting;
    private Speaker speaker;

    public Event(Meeting meeting, Speaker speaker) {
        this.meeting = meeting;
        this.speaker = speaker;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
