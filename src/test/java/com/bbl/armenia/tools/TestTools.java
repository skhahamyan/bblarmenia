package com.bbl.armenia.tools;

import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestTools {
    public static final int HTTP_CODE_OK = 200;

    public static <T> T fromJson(String jsonFileName, Class<T> expectedClass) {
        InputStream inputStream = getResourceAsInputStream(jsonFileName);
        JsonReader jsonReader = convertInputSteamToJsonReader(inputStream);
        return TextTool.GSON.fromJson(jsonReader, expectedClass);
    }

    private static InputStream getResourceAsInputStream(String jsonFileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(jsonFileName);
    }

    private static JsonReader convertInputSteamToJsonReader(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Reader reader = new BufferedReader(inputStreamReader);
        return new JsonReader(reader);
    }
}
