package com.bbl.armenia.ws;

import com.bbl.armenia.tools.TestTools;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeakerServiceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(SpeakerService.class);
    }

    @Test
    public void get_speakers_should_display_got_it() {
        Response response = target("speaker").request().get();
        assertEquals(TestTools.HTTP_CODE_OK, response.getStatus());
        assertEquals("Got it !", response.readEntity(String.class));
    }
}