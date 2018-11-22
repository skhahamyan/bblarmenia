package com.bbl.armenia.service;

import com.bbl.armenia.server.Database;
import com.bbl.armenia.user.Credential;
import com.google.inject.Singleton;
import org.jooq.generated.tables.records.CredentialRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.AuthenticationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.jooq.generated.tables.Credential.CREDENTIAL;

@Singleton
@Path("authentication")
public class AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String login() {
        return "Credential";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();

        try {
            authenticate(username, password);
            String token = issueToken(username);
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        CredentialRecord authenticatedUser = Database.getJOOQ().selectFrom(CREDENTIAL)
                .where(CREDENTIAL.USERNAME.eq(username))
                .and(CREDENTIAL.USER_PASSWORD.eq(password))
                .fetchOne();

        if (authenticatedUser == null) {
            LOGGER.error("Authentication failed");
            throw new AuthenticationException("Authentication failed");
        }
    }

    private String issueToken(String username) {
        return "token";
    }
}
