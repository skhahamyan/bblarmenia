package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;

public class Identity {
    private String firstName;
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
