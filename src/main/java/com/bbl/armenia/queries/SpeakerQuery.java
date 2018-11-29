package com.bbl.armenia.queries;

import com.bbl.armenia.server.Database;
import com.bbl.armenia.user.Identity;
import com.bbl.armenia.user.Speaker;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

import static org.jooq.generated.tables.Speaker.SPEAKER;

@Singleton
public class SpeakerQuery implements ReadOperation<Speaker>, WriteOperation<Speaker>, PurgeOperation {
    @Inject
    KnowledgeQuery knowledgeQuery;

    public SpeakerQuery() {
        // Test needs default constructor
    }

    @Override
    public List<Speaker> getAll() {
        return null;
    }

    @Override
    public Speaker getById(Long id) {
        return null;
    }

    @Override
    public void create(Speaker speaker) {
        Identity identity = speaker.getUser().getIdentity();
        Database.getJOOQ().insertInto(SPEAKER, SPEAKER.FIRST_NAME, SPEAKER.LAST_NAME)
                .values(identity.getFirstName(), identity.getLastName())
                .execute();
    }

    @Override
    public void update(Speaker speaker) {
        Identity identity = speaker.getUser().getIdentity();
        Database.getJOOQ().update(SPEAKER)
                .set(SPEAKER.FIRST_NAME, identity.getFirstName())
                .set(SPEAKER.LAST_NAME, identity.getLastName())
                .where(SPEAKER.ID.eq(speaker.getId()))
                .execute();
    }

    @Override
    public void delete(Long id) {
        knowledgeQuery.deleteBySpeakerId(id);
        Database.getJOOQ().delete(SPEAKER)
                .where(SPEAKER.ID.eq(id))
                .execute();
    }
}
