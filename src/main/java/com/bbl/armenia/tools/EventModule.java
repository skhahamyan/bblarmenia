package com.bbl.armenia.tools;

import com.bbl.armenia.queries.*;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

class EventModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReadOperation.class).to(EventQuery.class).in(Singleton.class);
        bind(WriteOperation.class).to(EventQuery.class).in(Singleton.class);
    }
}
