package com.bbl.armenia.company;

import com.bbl.armenia.tools.TextTool;
import com.google.gson.annotations.Expose;

public class Address {
    @Expose
    private String city;
    @Expose
    private String street;
    @Expose
    private String number;

    public Address() {
    }

    public Address(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return TextTool.GSON.toJson(this);
    }
}
