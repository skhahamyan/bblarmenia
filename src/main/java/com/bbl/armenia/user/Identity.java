package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;
import com.google.gson.annotations.Expose;

public class Identity {
    @Expose
    private String firstName;
    @Expose
    private String lastName;

    public Identity() {
    }

    public Identity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
