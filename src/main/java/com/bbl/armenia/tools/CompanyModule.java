package com.bbl.armenia.tools;

import com.bbl.armenia.queries.CompanyQuery;
import com.bbl.armenia.queries.PurgeOperation;
import com.bbl.armenia.queries.ReadOperation;
import com.bbl.armenia.queries.WriteOperation;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

class CompanyModule extends AbstractModule {
    private final static Named COMPANY = Names.named(AnnotatedWith.COMPANY.getName());

    @Override
    protected void configure() {
        bind(ReadOperation.class).annotatedWith(COMPANY).to(CompanyQuery.class).in(Singleton.class);
        bind(WriteOperation.class).annotatedWith(COMPANY).to(CompanyQuery.class).in(Singleton.class);
        bind(PurgeOperation.class).annotatedWith(COMPANY).to(CompanyQuery.class).in(Singleton.class);
    }
}
