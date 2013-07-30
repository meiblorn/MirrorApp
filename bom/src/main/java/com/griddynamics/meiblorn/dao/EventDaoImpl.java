package com.griddynamics.meiblorn.dao;

import com.griddynamics.meiblorn.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.core.GigaSpace;

public class EventDaoImpl implements EventDao {

    private GigaSpace gigaSpace;

    public EventDaoImpl() {

    }

    public EventDaoImpl(GigaSpace gigaSpace) {
        this.gigaSpace = gigaSpace;
    }

    public GigaSpace getGigaSpace() {
        return gigaSpace;
    }

    public void setGigaSpace(GigaSpace gigaSpace) {
        this.gigaSpace = gigaSpace;
    }

    @Override
    public void put(Event event) {
        gigaSpace.write(event);
    }

    @Override
    public Event get(int eventId) throws NoSuchEventException {
        Event event = gigaSpace.readIfExists(
                new SQLQuery<Event>(Event.class, String.format("id = %s", eventId)));
        if (null == event) {
            throw new NoSuchEventException();
        }
        return event;
    }

    @Override
    public void remove(int eventId) throws NoSuchEventException {
        Event event = gigaSpace.take(new SQLQuery<Event>(
                Event.class, String.format("id = %s", eventId)));
        if (null == event) {
            throw new NoSuchEventException();
        }
    }
}
