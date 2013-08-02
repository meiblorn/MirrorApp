package com.griddynamics.meiblorn.dao;

import com.griddynamics.meiblorn.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An implementation of {@link EventDao} interface, that provides interact mechanism with <tt>GigaSpace</tt>  interface using {@link Event} domain objects.
 * @since 1.0
 */
@Component
public class EventDaoImpl implements EventDao {

    private GigaSpace gigaSpace;

    /**
     * Constructs a new {@link EventDaoImpl} instance with exiting <tt>GigaSpace</tt> instance.
     * @param gigaSpace
     */
    public EventDaoImpl(GigaSpace gigaSpace) {
        this.gigaSpace = gigaSpace;
    }

    /**
     * Returns <tt>GigaSpace</tt>'s instance that interacts with the <tt>EventDaoImpl</tt>.
     * @return <tt>GigaSpace</tt>'s instance that interacts with the <tt>EventDaoImpl</tt>.
     */
    public GigaSpace getGigaSpace() {
        return gigaSpace;
    }

    /**
     * Sets the <tt>GigaSpace</tt> instance that interacts with the <tt>EventDaoImpl</tt>.
     * @param gigaSpace
     */
    public void setGigaSpace(GigaSpace gigaSpace) {
        this.gigaSpace = gigaSpace;
    }

    /**
     * Inserts the {@link Event} object into the <tt>GigaSpace</tt>'s instance space.
     * @param event the <tt>Event</tt> instance.
     */
    @Override
    public void put(Event event) {
        gigaSpace.write(event);
    }

    /**
     * Returns the <tt>Event</tt> object from the <tt>GigaSpace</tt>'s instance space with specified numeric identifier.
     * @param eventId the <tt>Event</tt> instance numeric identifier.
     * @return the <tt>Event</tt> object with specified numeric identifier.
     * @throws NoSuchEventException if there aren't in the <tt>GigaSpace</tt>'s instance space <tt>Event</tt> object with specified identifier.
     */
    @Override
    public Event get(int eventId) throws NoSuchEventException {
        Event event = gigaSpace.readIfExists(
                new SQLQuery<Event>(Event.class, String.format("id = %s", eventId)));
        if (null == event) {
            throw new NoSuchEventException();
        }
        return event;
    }

    /**
     * Removes the <tt>Event</tt> object with specified numeric identifier.
     * @param eventId the <tt>Event</tt> instance numeric identifier.
     * @throws NoSuchEventException if there aren't in the <tt>GigaSpace</tt>'s instance space <tt>Event</tt> object with specified identifier.
     */
    @Override
    public void remove(int eventId) throws NoSuchEventException {
        Event event = gigaSpace.take(new SQLQuery<Event>(
                Event.class, String.format("id = %s", eventId)));
        if (null == event) {
            throw new NoSuchEventException();
        }
    }
}
