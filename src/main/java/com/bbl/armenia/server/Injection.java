package com.bbl.armenia.server;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Injection extends AbstractModule {
    private static final Injector GUICE = initialize();

    private static Injector initialize() {
        return Guice.createInjector(new MainModule());
    }

    public static <T> T getInstance(Class<T> clazz) {
        return GUICE.getInstance(clazz);
    }

    private static class MainModule extends AbstractModule {
        @Override
        protected void configure() {
            // Configure bindings here
        }
    }
}
