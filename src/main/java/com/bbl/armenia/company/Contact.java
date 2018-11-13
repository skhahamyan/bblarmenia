package com.bbl.armenia.company;

import com.bbl.armenia.company.Address;
import com.bbl.armenia.company.Company;
import com.bbl.armenia.tools.TextTool;

import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = -4136674511030322129L;

    private String phoneNumber;
    private Address address;

    public Contact(String phoneNumber, Address address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
