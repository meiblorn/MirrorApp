package com.griddynamics.meiblorn.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Events
 *
 * @author Alex Rodin
 *         Date: 8/1/13
 *         Time: 5:30 PM
 */
public class Events implements Serializable {
    private List<Event> events;

    public Events() {
    }

    public Events(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
