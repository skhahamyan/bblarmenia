package com.bbl.armenia.server;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceInjector {
    private static final Injector GUICE = initialize();

    private static Injector initialize() {
        Injector injector = Guice.createInjector(new GuiceModule());
        return injector;
    }

    public static Injector injector() {
        return GUICE;
    }
}
