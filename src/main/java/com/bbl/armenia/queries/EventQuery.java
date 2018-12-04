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
import static org.jooq.generated.tables.Speaker.SPEAKER;

@Singleton
public class EventQuery implements ReadOperation<Event>, WriteOperation<EventRequest> {
    @Override
    public List<Event> getAll() {
        Result<Record> eventRecords = selectJoinStep().where(SPEAKER.ID.eq(1L))
                .and(EVENT.EVENT_CANCELED.isFalse()).fetch();
        return eventRecords.stream().map(QueryMappers::mapEvent).collect(Collectors.toList());
    }

    @Override
    public Event getById(Long id) {
        Record eventRecord = selectJoinStep().where(SPEAKER.ID.eq(1L))
                .and(EVENT.ID.eq(id))
                .and(EVENT.EVENT_CANCELED.isFalse()).fetchOne();
        return QueryMappers.mapEvent(eventRecord);
    }

    @Override
    public void create(EventRequest eventRequest) {
        Database.getJOOQ().insertInto(EVENT, EVENT.SPEAKER_ID, EVENT.KNOWLEDGE_ID, EVENT.COMPANY_ID, EVENT.MEETING_DATE)
                .values(1L, eventRequest.getKnowledgeId(), eventRequest.getCompanyId(), eventRequest.getMeetingDate())
                .execute();
    }

    @Override
    public void update(EventRequest eventRequest) {
        // TODO only event creator or speaker can update
        Database.getJOOQ().update(EVENT)
                .set(EVENT.MEETING_DATE, eventRequest.getMeetingDate())
                .where(EVENT.ID.eq(eventRequest.getId()))
                .and(EVENT.EVENT_CANCELED.isFalse())
                .execute();
    }

    public void cancel(Long id) {
        // TODO only event creator or speaker can update
        Database.getJOOQ().update(EVENT)
                .set(EVENT.EVENT_CANCELED, Byte.valueOf("1"))
                .where(EVENT.ID.eq(id))
                .and(EVENT.EVENT_CANCELED.isFalse())
                .execute();
    }

    private SelectJoinStep<Record> selectJoinStep() {
        return Database.getJOOQ().select()
                .from(EVENT)
                .leftJoin(SPEAKER).onKey()
                .leftJoin(KNOWLEDGE).onKey()
                .leftJoin(COMPANY).onKey();
    }
}
