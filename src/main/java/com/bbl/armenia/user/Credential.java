package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Credential implements Serializable {
    private static final long serialVersionUID = 1752442737185356929L;

    @Expose
    private String username;
    private String password;

    public Credential() {
        // Default constructor
    }

    public Credential(String username) {
        this.username = username;
    }

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
