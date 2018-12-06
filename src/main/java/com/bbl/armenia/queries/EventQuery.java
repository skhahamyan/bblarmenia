package com.bbl.armenia.queries;

import com.bbl.armenia.event.Event;
import com.bbl.armenia.server.Database;
import com.bbl.armenia.service.EventRequest;
import com.google.inject.Singleton;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectJoinStep;

import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.generated.tables.Company.COMPANY;
import static org.jooq.generated.tables.Event.EVENT;
import static org.jooq.generated.tables.Knowledge.KNOWLEDGE;

@Singleton
public class EventQuery implements ReadOperation<Event>, WriteOperation<EventRequest> {
    @Override
    public List<Event> getAll() {
        Result<Record> eventRecords = selectJoinStep().where(EVENT.ORGANIZER_ID.eq(1L)).fetch();
        return eventRecords.stream().map(QueryMappers::mapEvent).collect(Collectors.toList());
    }

    public List<Event> getAllBySpeakerId(Long speakerId) {
        Result<Record> eventRecords = selectJoinStep().where(EVENT.SPEAKER_ID.eq(speakerId)).fetch();
        return eventRecords.stream().map(QueryMappers::mapEvent).collect(Collectors.toList());
    }

    @Override
    public Event getById(Long id) {
        Record eventRecord = selectJoinStep().where(EVENT.ID.eq(id)).fetchOne();
        return QueryMappers.mapEvent(eventRecord);
    }

    @Override
    public void create(EventRequest eventRequest) {
        Database.getJOOQ().insertInto(EVENT)
                .set(EVENT.ORGANIZER_ID, 1L)
                .set(EVENT.SPEAKER_ID, eventRequest.getSpeakerId())
                .set(EVENT.KNOWLEDGE_ID, eventRequest.getKnowledgeId())
                .set(EVENT.COMPANY_ID, eventRequest.getCompanyId())
                .set(EVENT.MEETING_DATE, eventRequest.getMeetingDate())
                .execute();
    }

    @Override
    public void update(EventRequest eventRequest) {
        Database.getJOOQ().update(EVENT)
                .set(EVENT.MEETING_DATE, eventRequest.getMeetingDate())
                .where(EVENT.ID.eq(eventRequest.getId()))
                .and(EVENT.ORGANIZER_ID.eq(1L).or(EVENT.SPEAKER_ID.eq(eventRequest.getSpeakerId())))
                .and(EVENT.EVENT_CANCELED.isFalse())
                .execute();
    }

    public void accept(Long id) {
        Database.getJOOQ().update(EVENT)
                .set(EVENT.EVENT_ACCEPTED, Byte.valueOf("1"))
                .where(EVENT.ID.eq(id))
                .and(EVENT.SPEAKER_ID.eq(1L))
                .and(EVENT.EVENT_CANCELED.isFalse())
                .execute();
    }

    public void cancel(Long id) {
        Database.getJOOQ().update(EVENT)
                .set(EVENT.EVENT_CANCELED, Byte.valueOf("1"))
                .where(EVENT.ID.eq(id))
                .and(EVENT.ORGANIZER_ID.eq(1L))
                .and(EVENT.EVENT_ACCEPTED.isFalse())
                .execute();
    }

    private SelectJoinStep<Record> selectJoinStep() {
        return Database.getJOOQ().select()
                .from(EVENT)
                .leftJoin(KNOWLEDGE).onKey()
                .leftJoin(COMPANY).onKey();
    }
}
