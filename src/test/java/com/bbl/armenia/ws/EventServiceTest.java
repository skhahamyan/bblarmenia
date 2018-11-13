package com.bbl.armenia.ws;

import com.bbl.armenia.company.Address;
import com.bbl.armenia.company.Contact;
import com.bbl.armenia.tools.TestTools;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventServiceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(EventService.class);
    }

    @Test
    public void get_events_should_display_my_event() {
        Response response = target("event").request().get();
        assertEquals(TestTools.HTTP_CODE_OK, response.getStatus());
        assertEquals("My event", response.readEntity(String.class));
    }
}