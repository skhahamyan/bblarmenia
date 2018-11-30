package com.bbl.armenia.service;

import java.io.Serializable;

public class KnowledgeRequest implements Serializable {
    private static final long serialVersionUID = -1541734622054919553L;

    private Long id;
    private String title;
    private String description;
    private Long speakerId;

    public KnowledgeRequest() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getSpeakerId() {
        return speakerId;
    }
}
