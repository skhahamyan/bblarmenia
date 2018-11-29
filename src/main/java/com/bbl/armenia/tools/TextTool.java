package com.bbl.armenia.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TextTool {
    public final static Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
}
