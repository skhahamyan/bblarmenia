package com.bbl.armenia.service;

import java.io.Serializable;

public class SpeakerRequest implements Serializable {
    private static final long serialVersionUID = -1891185869107945468L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public SpeakerRequest() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
