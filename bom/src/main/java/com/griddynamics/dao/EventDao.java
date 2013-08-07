package com.griddynamics.dao;

import com.griddynamics.domain.Event;

import java.util.List;

/**
 *<p><b>{@link Event}</b> data access object (DAO) interface, that provides interact mechanism with some database or any other persistence model by mapping DAO methods to the persistence layer transactions.</p>
 *
 *<p>The {@link EventDao} interface provides three methods for element access, insertion or removing.</p>
 *
 * @since 1.0
 */
public interface EventDao {
    /**
     * Inserts the {@link Event} object into the persistence model storage.
     *
     * @param event the <tt>Event</tt> instance.
     */
    void put(Event event);

    /**
     * Returns the <tt>Event</tt> instance with specified numeric identifier.
     *
     * @param eventId the <tt>Event</tt> object identifier.
     * @return the <tt>Event</tt> instance.
     * @throws NoSuchEventException if there aren't <tt>Event</tt> object with specified identifier.
     */
    Event get(int eventId) throws NoSuchEventException;

    /**
     * Returns all <tt>Event</tt> objects from the persistence model storage.
     *
     * @return the <tt>Event</tt> objects list.
     */
    List<Event> getAll();

    /**
     * Removes the <tt>Event</tt> object with specified numeric identifier.
     *
     * @param eventId the <tt>Event</tt> object identifier.
     * @throws NoSuchEventException if there aren't <tt>Event</tt> object with specified identifier.
     */
    void remove(int eventId) throws NoSuchEventException;
}
