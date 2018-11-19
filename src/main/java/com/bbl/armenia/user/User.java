package com.bbl.armenia.user;

import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -720813431410062400L;

    private Credential credential;
    private Identity identity;

    public User() {
    }

    public User(Credential credential, Identity identity) {
        this.credential = credential;
        this.identity = identity;
    }

    public Credential getCredential() {
        return credential;
    }

    public Identity getIdentity() {
        return identity;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
