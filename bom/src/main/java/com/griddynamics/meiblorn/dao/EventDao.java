package com.griddynamics.meiblorn.dao;

import com.griddynamics.meiblorn.domain.Event;

/**
 * <p><b>{@link Event}</b> data access object (DAO) interface, provides interact mechanism with some database or any other persistence model by mapping DAO methods to the persistence layer transactions.</p>
 *
 *<p>The {@link EventDao} interface provides three methods for element access, insertion or removing.</p>
 * @since 1.0
 */
public interface EventDao {
    /**
     * Inserts the {@link Event} object into persistence model storage.
     * @param event the <tt>Event</tt> instance.
     */
    void put(Event event);

    /**
     * Returns the <tt>Event</tt> object with specified numeric identifier.
     * @param eventId the event's identifier.
     * @return the <tt>Event</tt> object with specified numeric identifier.
     * @throws NoSuchEventException if there aren't <tt>Event</tt> object with specified identifier
     */
    Event get(int eventId) throws NoSuchEventException;

    /**
     * Removes the <tt>Event</tt> object with specified numeric identifier.
     * @param eventId the <tt>Event</tt> instance identifier.
     * @throws NoSuchEventException if there aren't <tt>Event</tt> object with specified identifier.
     */
    void remove(int eventId) throws NoSuchEventException;
}
