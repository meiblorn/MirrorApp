package com.griddynamics.meiblorn.dao;

import com.griddynamics.meiblorn.domain.Event;

public interface EventDao {
    void put(Event event) throws AlreadyInSpaceException;
    Event get(int eventId) throws NoSuchEventException;
    void remove(int eventId) throws NoSuchEventException;
}
