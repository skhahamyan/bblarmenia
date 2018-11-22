package com.bbl.armenia.queries;

import com.bbl.armenia.server.Database;
import com.bbl.armenia.user.Identity;
import com.bbl.armenia.user.Speaker;

import static org.jooq.generated.tables.Speaker.SPEAKER;

public class SpeakerQuery implements ReadOperation, WriteOperation<Speaker>, PurgeOperation {
    public SpeakerQuery() {
        // Test needs default constructor
    }

    @Override
    public void getAll() {

    }

    @Override
    public void getById() {

    }

    @Override
    public void create(Speaker speaker) {
        Identity identity = speaker.getUser().getIdentity();
        Database.getJOOQ().insertInto(SPEAKER, SPEAKER.FIRST_NAME, SPEAKER.LAST_NAME)
                .values(identity.getFirstName(), identity.getLastName())
                .execute();
    }

    @Override
    public void update(Long id, Speaker speaker) {
        Identity identity = speaker.getUser().getIdentity();
        Database.getJOOQ().update(SPEAKER)
                .set(SPEAKER.FIRST_NAME, identity.getFirstName())
                .set(SPEAKER.LAST_NAME, identity.getLastName())
                .where(SPEAKER.ID.eq(id))
                .execute();
    }

    @Override
    public void delete(Long id) {
        Database.getJOOQ().delete(SPEAKER)
                .where(SPEAKER.ID.eq(id))
                .execute();
    }
}
