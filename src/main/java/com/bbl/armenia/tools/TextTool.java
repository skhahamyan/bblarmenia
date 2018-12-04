package com.bbl.armenia.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextTool {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public final static Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static String fromDateToString(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_FORMATTER);
    }

    public static LocalDateTime fromStringToDate(String date) {
        return LocalDateTime.parse(date, DATE_FORMATTER);
    }
}
