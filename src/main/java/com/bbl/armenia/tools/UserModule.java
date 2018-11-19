package com.bbl.armenia.tools;

import com.bbl.armenia.queries.PurgeOperation;
import com.bbl.armenia.queries.ReadOperation;
import com.bbl.armenia.queries.SpeakerQuery;
import com.bbl.armenia.queries.WriteOperation;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

class UserModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReadOperation.class).to(SpeakerQuery.class).in(Singleton.class);
        bind(WriteOperation.class).to(SpeakerQuery.class).in(Singleton.class);
        bind(PurgeOperation.class).to(SpeakerQuery.class).in(Singleton.class);
    }
}
