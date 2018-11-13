package com.bbl.armenia.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("registration")
public class RegistrationService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String login() {
        return "Login";
    }
}
