package com.bbl.armenia.company;

import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;

public class Company implements Serializable {
    private static final long serialVersionUID = 4510078668878462629L;

    private String name;
    private Contact contact;

    public Company(String name, Contact contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
