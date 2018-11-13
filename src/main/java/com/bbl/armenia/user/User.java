package com.bbl.armenia.user;

import com.bbl.armenia.company.Contact;
import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -720813431410062400L;

    private Login login;
    private Identity identity;
    private Contact contact;

    public Login getLogin() {
        return login;
    }

    public Identity getIdentity() {
        return identity;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
