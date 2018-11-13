package com.bbl.armenia.ws;

import com.bbl.armenia.company.Address;
import com.bbl.armenia.company.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("event")
public class EventService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        Contact contact = new Contact("0123456789",
                new Address("city", "street", "number"));
        return contact.toString();
    }
}
