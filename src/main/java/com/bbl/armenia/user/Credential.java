package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;

public class Credential implements Serializable {
    private static final long serialVersionUID = 1752442737185356929L;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
