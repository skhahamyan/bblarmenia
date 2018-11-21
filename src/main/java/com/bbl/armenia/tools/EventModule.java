package com.bbl.armenia.tools;

import com.bbl.armenia.queries.*;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

class EventModule extends AbstractModule {
    private final static Named EVENT = Names.named(AnnotatedWith.EVENT.getName());

    @Override
    protected void configure() {
        bind(ReadOperation.class).annotatedWith(EVENT).to(EventQuery.class).in(Singleton.class);
        bind(WriteOperation.class).annotatedWith(EVENT).to(EventQuery.class).in(Singleton.class);
    }
}
