package com.griddynamics.meiblorn.dao.implementation;

import com.griddynamics.meiblorn.dao.IEventDao;
import com.griddynamics.meiblorn.domain.Event;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;

import java.util.logging.Logger;

public class EventDaoImpl implements IEventDao {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @GigaSpaceContext
    private GigaSpace gigaSpace;

    public EventDaoImpl() {
        super();
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
