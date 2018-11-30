package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -720813431410062400L;

    @Expose
    private Credential credential;
    @Expose
    private Identity identity;
    @Expose
    private String email;
    @Expose
    private String phoneNumber;

    public User() {
        // Default constructor
    }

    public User(Credential credential, Identity identity, String email, String phoneNumber) {
        this.credential = credential;
        this.identity = identity;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Credential getCredential() {
        return credential;
    }

    public Identity getIdentity() {
        return identity;
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
