package com.bbl.armenia.company;

import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;

public class Company implements Serializable {
    private static final long serialVersionUID = 4510078668878462629L;

    private Long id;
    private String name;
    private Contact contact;

    public Company() {
        // Default constructor
    }

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(Long id, String name, Contact contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public Long getId() {
        return id;
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
