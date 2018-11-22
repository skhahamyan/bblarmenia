package com.bbl.armenia.server;

import com.bbl.armenia.queries.*;
import com.bbl.armenia.tools.Company;
import com.bbl.armenia.tools.Event;
import com.bbl.armenia.tools.User;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

public class RestModule extends ServletModule {
    private final ResourceConfig resourceConfig;

    RestModule(ResourceConfig resourceConfig) {
        this.resourceConfig = resourceConfig;
    }

    @Override
    protected void configureServlets() {
        bindUserOperations();
        bindCompanyOperations();
        bindEventOperations();

        for (Class<?> resource : resourceConfig.getClasses()) {
            bind(resource);
        }

        bind(JacksonJsonProvider.class).in(Singleton.class);
        serve("/api/*").with(GuiceContainer.class);
    }

    private void bindUserOperations() {
        bind(ReadOperation.class).annotatedWith(User.class).to(SpeakerQuery.class);
        bind(WriteOperation.class).annotatedWith(User.class).to(SpeakerQuery.class);
        bind(PurgeOperation.class).annotatedWith(User.class).to(SpeakerQuery.class);
    }

    private void bindCompanyOperations() {
        bind(ReadOperation.class).annotatedWith(Company.class).to(CompanyQuery.class);
        bind(WriteOperation.class).annotatedWith(Company.class).to(CompanyQuery.class);
        bind(PurgeOperation.class).annotatedWith(Company.class).to(CompanyQuery.class);
    }

    private void bindEventOperations() {
        bind(ReadOperation.class).annotatedWith(Event.class).to(EventQuery.class);
        bind(WriteOperation.class).annotatedWith(Event.class).to(EventQuery.class);
    }
}
