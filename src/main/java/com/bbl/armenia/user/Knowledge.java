package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;

public class Knowledge {
    private String title;
    private String description;

    public Knowledge(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
