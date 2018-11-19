package com.bbl.armenia.tools;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectionTool {
    public final static Injector USER = Guice.createInjector(new UserModule());
    public final static Injector EVENT = Guice.createInjector(new EventModule());
    public final static Injector COMPANY = Guice.createInjector(new CompanyModule());
}
