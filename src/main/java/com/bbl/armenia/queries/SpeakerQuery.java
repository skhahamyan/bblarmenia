package com.bbl.armenia.queries;

import com.bbl.armenia.server.Database;
import com.bbl.armenia.service.SpeakerRequest;
import com.bbl.armenia.user.Speaker;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.TableField;
import org.jooq.generated.tables.records.SpeakerRecord;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.generated.tables.Company.COMPANY;
import static org.jooq.generated.tables.Credential.CREDENTIAL;
import static org.jooq.generated.tables.Speaker.SPEAKER;

@Singleton
public class SpeakerQuery implements ReadOperation<Speaker>, WriteOperation<SpeakerRequest>, PurgeOperation {
    @Inject
    KnowledgeQuery knowledgeQuery;

    public SpeakerQuery() {
        // Default constructor
    }

    @Override
    public List<Speaker> getAll() {
        Result<Record> speakerRecords = Database.getJOOQ().select()
                .from(SPEAKER)
                .leftJoin(COMPANY).onKey()
                .leftJoin(CREDENTIAL).onKey()
                .fetch();

        return speakerRecords.stream().map(QueryMappers::mapSpeaker).collect(Collectors.toList());
    }

    @Override
    public Speaker getById(Long id) {
        return null;
    }

    @Override
    public void create(SpeakerRequest speakerRequest) {
        final List<TableField<SpeakerRecord, String>> CREATE_SPEAKER_FIELDS = Arrays.asList(
                SPEAKER.FIRST_NAME, SPEAKER.LAST_NAME, SPEAKER.EMAIL, SPEAKER.PHONE_NUMBER);

        Database.getJOOQ().insertInto(SPEAKER, CREATE_SPEAKER_FIELDS)
                .values(speakerRequest.getFirstName(), speakerRequest.getLastName(),
                        speakerRequest.getEmail(), speakerRequest.getPhoneNumber())
                .execute();
    }

    @Override
    public void update(SpeakerRequest speakerRequest) {
        Database.getJOOQ().update(SPEAKER)
                .set(SPEAKER.FIRST_NAME, speakerRequest.getFirstName())
                .set(SPEAKER.LAST_NAME, speakerRequest.getLastName())
                .set(SPEAKER.EMAIL, speakerRequest.getEmail())
                .set(SPEAKER.PHONE_NUMBER, speakerRequest.getPhoneNumber())
                .where(SPEAKER.ID.eq(speakerRequest.getId()))
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
