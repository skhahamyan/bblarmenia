package com.bbl.armenia.service;

import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class EventRequest implements Serializable {
    private static final long serialVersionUID = 7610314109371498120L;

    private Long id;
    private Long speakerId;
    private Long knowledgeId;
    private Long companyId;
    private String meetingDate;

    public EventRequest() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Timestamp getMeetingDate() {
        LocalDateTime localDateTime = TextTool.fromStringToDate(meetingDate);
        return Timestamp.valueOf(localDateTime);
    }
}
