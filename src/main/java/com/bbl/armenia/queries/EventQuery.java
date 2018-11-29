package com.bbl.armenia.queries;

import com.bbl.armenia.event.Event;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class EventQuery implements ReadOperation<Event>, WriteOperation<Event> {
    @Override
    public List<Event> getAll() {
        return null;
    }

    @Override
    public Event getById(Long id) {
        return null;
    }

    @Override
    public void create(Event speaker) {

    }

    @Override
    public void update(Event speaker) {

    }
}
