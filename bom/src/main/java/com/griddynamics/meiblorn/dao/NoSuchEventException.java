package com.griddynamics.meiblorn.dao;

/**
 * General exception used by the {@link EventDao} implementations. Can be thrown when an application attempts to use null <tt>Event</tt>.
 * @since 1.0
 */
public class NoSuchEventException extends Exception {

    /**
     * Constructs a <tt>NoSuchEventException</tt> with no detail message.
     */
    public NoSuchEventException() {
        super();
    }

    /**
     * Constructs a <tt>NoSuchEventException</tt> with the specified detail message.
     * @param message the specified detail message.
     */
    public NoSuchEventException(String message) {
        super(message);
    }
}
