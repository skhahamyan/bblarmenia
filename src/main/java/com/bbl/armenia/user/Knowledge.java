package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Knowledge implements Serializable {
    private static final long serialVersionUID = -8410293204752815034L;

    @Expose
    private Long id;
    @Expose
    private String title;
    @Expose
    private String description;

    public Knowledge() {
    }

    public Knowledge(String title, String description) {
        this.title = title;
        this.description = description;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
