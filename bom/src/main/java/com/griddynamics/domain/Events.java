package com.griddynamics.domain;

import java.io.Serializable;
import java.util.List;

/**
 * The {@link Event} wrapper for JSON responses;
 *
 * @author Alex Rodin
 *         Date: 8/1/13
 *         Time: 5:30 PM
 *
 * @since 1.0
 */
public class Events implements Serializable {
    private List<Event> events;

    /**
     * Constructs a new <tt>Events</tt> instance with null <tt>Event</tt> list.
     */
    public Events() {
    }

    /**
     * Constructs a new <tt>Event</tt> instance with specified <tt>Event</tt> list.
     */
    public Events(List<Event> events) {
        this.events = events;
    }

    /**
     * Returns the <tt>Event</tt> list.
     *
     * @return the <tt>Event</tt> list.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets the <tt>Event</tt> list.
     *
     * @param events the <tt>Event</tt> list.
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
