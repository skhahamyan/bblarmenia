package com.bbl.armenia.tools;

enum AnnotatedWith {
    USER("User"),
    EVENT("Event"),
    COMPANY("Company");

    private final String name;

    AnnotatedWith(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
