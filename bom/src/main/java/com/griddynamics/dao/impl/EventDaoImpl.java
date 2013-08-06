package com.griddynamics.dao.impl;

import com.griddynamics.dao.EventDao;
import com.griddynamics.dao.GigaFactory;
import com.griddynamics.dao.NoSuchEventException;
import com.griddynamics.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An implementation of {@link EventDao} interface, that provides interact mechanism with <tt>GigaSpace</tt>  interface using {@link Event} domain objects.
 * @since 1.0
 */
@Component
public class EventDaoImpl implements EventDao {
    @Autowired
    private GigaFactory gigaFactory;

    /**
     * Inserts the {@link Event} object into the <tt>GigaSpace</tt>'s instance space.
     * @param event the <tt>Event</tt> instance.
     */
    @Override
    @Transactional
    public void put(Event event) {
        gigaFactory.getGigaSpace().write(event);
    }

    /**
     * Returns the <tt>Event</tt> object from the <tt>GigaSpace</tt>'s instance space with specified numeric identifier.
     * @param eventId the <tt>Event</tt> instance numeric identifier.
     * @return the <tt>Event</tt> object with specified numeric identifier.
     * @throws NoSuchEventException if there aren't in the <tt>GigaSpace</tt>'s instance space <tt>Event</tt> object with specified identifier.
     */
    @Override
    @Transactional(readOnly = true)
    public Event get(int eventId) throws NoSuchEventException {
        Event event = gigaFactory.getGigaSpace().readIfExists(
                new SQLQuery<Event>(Event.class, String.format("id = %s", eventId)));
        return event;
    }

    /**
     * TODO: Complete
     * @return
     */
    @Transactional(readOnly = true)
    public List<Event> getAll() {
        Event[] eventArray = gigaFactory.getGigaSpace().readMultiple(new SQLQuery<Event>(Event.class, "id is NOT null"));
        return new ArrayList<Event>(Arrays.asList(eventArray));
    }

    /**
     * Removes the <tt>Event</tt> object with specified numeric identifier.
     * @param eventId the <tt>Event</tt> instance numeric identifier.
     * @throws NoSuchEventException if there aren't in the <tt>GigaSpace</tt>'s instance space <tt>Event</tt> object with specified identifier.
     */
    @Override
    @Transactional
    public void remove(int eventId) throws NoSuchEventException {
        gigaFactory.getGigaSpace().take(new SQLQuery<Event>(
                Event.class, String.format("id = %s", eventId)));
    }
}
