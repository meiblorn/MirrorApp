package com.griddynamics.domain;

import java.io.Serializable;

/**
 * The simple domain Plain Old Java Object (POJO).
 * @since 1.0
 */
public class Event implements Serializable {
    private int id;
    private String message;

    /**
     * Constructs a new <tt>Event</tt> instance with null as its identifier and detail message.
     */
    public Event() {

    }

    /**
     * Constructs a new <tt>Event</tt> instance with the specified numeric identifier and detail message.
     * @param id the numeric identifier of the <tt>Event</tt> instance.
     * @param message the detailed message describing the <tt>Event</tt> instance.
     */
    public Event(int id, String message) {
        this.id = id;
        this.message = message;
    }

    /**
     * Returns the <tt>Event</tt> instance numeric identifier.
     * @return integer value identifying this <tt>Event</tt> instance.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the <tt>Event</tt> instance identifier.
     * @param id the <tt>Event</tt> instance identifier.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the <tt>Event</tt> instance detailed message.
     * @return string value of the <tt>Event</tt> instance detailed message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the <tt>Event</tt> instance detailed message.
     * @param message the <tt>Event</tt> instance detailed message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns representation of this <tt>Event</tt> instance.
     * @return string representation of this <tt>Event</tt> instance.
     */
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
