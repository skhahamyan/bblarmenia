package com.bbl.armenia.tools;

import com.bbl.armenia.queries.PurgeOperation;
import com.bbl.armenia.queries.ReadOperation;
import com.bbl.armenia.queries.SpeakerQuery;
import com.bbl.armenia.queries.WriteOperation;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

class UserModule extends AbstractModule {
    private final static Named USER = Names.named(AnnotatedWith.USER.getName());

    @Override
    protected void configure() {
        bind(ReadOperation.class).annotatedWith(USER).to(SpeakerQuery.class).in(Singleton.class);
        bind(WriteOperation.class).annotatedWith(USER).to(SpeakerQuery.class).in(Singleton.class);
        bind(PurgeOperation.class).annotatedWith(USER).to(SpeakerQuery.class).in(Singleton.class);
    }
}
