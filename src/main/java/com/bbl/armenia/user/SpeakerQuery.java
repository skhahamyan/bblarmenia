package com.bbl.armenia.user;

import com.bbl.armenia.server.Database;
import org.jooq.DSLContext;
import org.jooq.generated.tables.Author;

public class SpeakerQuery {

    private final String speaker = "speaker";

    public void createSpeaker() {
        DSLContext jooq = Database.getJOOQ();
        jooq.insertInto(Author.AUTHOR).values();
    }
}
