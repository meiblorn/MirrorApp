package com.griddynamics.meiblorn.dao;

import com.griddynamics.meiblorn.domain.Event;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.context.GigaSpaceContext;
import org.openspaces.core.space.UrlSpaceConfigurer;

import java.util.logging.Logger;

public class EventDaoImpl implements EventDao {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private GigaSpace gigaSpace;

    public EventDaoImpl() {
        gigaSpace = new GigaSpaceConfigurer(new UrlSpaceConfigurer("/./space")).gigaSpace();
    }

    @Override
    public void put(Event event) {
        logger.info("EVENT_DAO_LOG: Put Event-object");
        gigaSpace.write(event);
    }

    @Override
    public Event get(int eventId) {
        logger.info("EVENT_DAO_LOG: Get Event-object with id: " + eventId);

        Event template = new Event();
        template.setId(eventId);
        Event event = gigaSpace.readIfExists(template);

        logger.info("EVENT_DAO_LOG: Return Event-object");

        return event;
    }

    @Override
    public void remove(int eventId) {
        logger.info("EVENT_DAO_LOG: Remove Event-object with id: " + eventId);
        Event template = new Event();
        template.setId(eventId);
        gigaSpace.clear(template);
    }
}
