package com.bbl.armenia.service;

import java.io.Serializable;
import java.util.Date;

public class EventRequest implements Serializable {
    private static final long serialVersionUID = 7610314109371498120L;

    private Long id;
    private Long speakerId;
    private Long knowledgeId;
    private Long companyId;
    private Date meetingDate;

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

    public Date getMeetingDate() {
        return meetingDate;
    }
}
