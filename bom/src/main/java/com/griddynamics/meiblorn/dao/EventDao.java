package com.griddynamics.meiblorn.dao;

import com.griddynamics.meiblorn.domain.Event;

public interface EventDao {
    void put(Event event);
    Event get(int eventId) throws NoSuchEventException;
    void remove(int eventId) throws NoSuchEventException;
}
