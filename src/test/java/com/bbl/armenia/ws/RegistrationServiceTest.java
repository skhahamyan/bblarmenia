package com.bbl.armenia.ws;

import com.bbl.armenia.tools.TestTools;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationServiceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(RegistrationService.class);
    }

    @Test
    public void login_service_should_display_login() {
        Response response = target("registration").request().get();
        assertEquals(TestTools.HTTP_CODE_OK, response.getStatus());
        assertEquals("Login", response.readEntity(String.class));
    }
}