package com.bbl.armenia.tools;

import com.bbl.armenia.queries.*;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

class CompanyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReadOperation.class).to(CompanyQuery.class).in(Singleton.class);
        bind(WriteOperation.class).to(CompanyQuery.class).in(Singleton.class);
        bind(PurgeOperation.class).to(CompanyQuery.class).in(Singleton.class);
    }
}
