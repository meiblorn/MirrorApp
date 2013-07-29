package com.griddynamics.meiblorn.dao;

import com.griddynamics.meiblorn.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import java.util.logging.Logger;

public class EventDaoImpl implements EventDao {

    private GigaSpace gigaSpace;

    public EventDaoImpl() {
        gigaSpace = new GigaSpaceConfigurer(new UrlSpaceConfigurer("/./space")).gigaSpace();
    }

    @Override
    public void put(Event event) {
        gigaSpace.write(event);
    }

    @Override
    public Event get(int eventId) throws NoSuchEventException {
        Event event = gigaSpace.readIfExists(
                new SQLQuery<Event>(Event.class, String.format("id = %d", eventId)));
        if (null == event) {
            throw new NoSuchEventException();
        }
        return event;
    }

    @Override
    public void remove(int eventId) throws NoSuchEventException {
        Event event = gigaSpace.take(new SQLQuery<Event>(
                Event.class, String.format("id = %d", eventId)));
        if (null == event) {
            throw new NoSuchEventException();
        }
    }
}
