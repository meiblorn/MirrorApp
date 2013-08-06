package com.griddynamics.meiblorn.dao.impl;

import com.griddynamics.meiblorn.dao.EventDao;
import com.griddynamics.meiblorn.dao.GigaFactory;
import com.griddynamics.meiblorn.dao.NoSuchEventException;
import com.griddynamics.meiblorn.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EventDaoImpl implements EventDao {
    @Autowired
    private GigaFactory gigaFactory;

    @Override
    @Transactional
    public void put(Event event) {
        gigaFactory.getGigaSpace().write(event);
    }

    @Override
    @Transactional(readOnly = true)
    public Event get(int eventId) throws NoSuchEventException {
        Event event = gigaFactory.getGigaSpace().readIfExists(
                new SQLQuery<Event>(Event.class, String.format("id = %s", eventId)));
        return event;
    }

    @Transactional(readOnly = true)
    public List<Event> getAll() {
        Event[] eventArray = gigaFactory.getGigaSpace().readMultiple(new SQLQuery<Event>(Event.class, "id is NOT null"));
        return new ArrayList<Event>(Arrays.asList(eventArray));
    }

    @Override
    @Transactional
    public void remove(int eventId) throws NoSuchEventException {
        gigaFactory.getGigaSpace().take(new SQLQuery<Event>(
                Event.class, String.format("id = %s", eventId)));
    }
}
