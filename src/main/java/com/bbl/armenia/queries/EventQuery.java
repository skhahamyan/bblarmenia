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
        Result<Record> eventRecords = selectJoinStep().where(SPEAKER.ID.eq(1L)).fetch();
        return eventRecords.stream().map(QueryMappers::mapEvent).collect(Collectors.toList());
    }

    @Override
    public Event getById(Long id) {
        return null;
    }

    @Override
    public void create(EventRequest eventRequest) {

    }

    @Override
    public void update(EventRequest eventRequest) {

    }

    public void cancel(Long id) {

    }

    private SelectJoinStep<Record> selectJoinStep() {
        return Database.getJOOQ().select()
                .from(EVENT)
                .leftJoin(SPEAKER).onKey()
                .leftJoin(KNOWLEDGE).onKey()
                .leftJoin(COMPANY).onKey();
    }
}
