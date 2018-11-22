package com.bbl.armenia.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class RestServletContext extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        final ResourceConfig resourceConfig = new PackagesResourceConfig("com.bbl.armenia.service");
        return Guice.createInjector(new RestModule(resourceConfig));
    }
}
