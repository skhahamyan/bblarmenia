package com.bbl.armenia.service;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

public class SpeakerServiceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(SpeakerService.class);
    }
}