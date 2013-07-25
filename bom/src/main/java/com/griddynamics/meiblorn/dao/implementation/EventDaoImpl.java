package com.griddynamics.meiblorn.dao.implementation;

import com.griddynamics.meiblorn.dao.IEventDao;
import com.griddynamics.meiblorn.domain.Event;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;

import java.util.logging.Logger;

public class EventDaoImpl implements IEventDao {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @GigaSpaceContext(name = "gigaSpace")
    private GigaSpace gigaSpace;

    public EventDaoImpl() {
        super();
    }

    @Override
    public void put(Event event) {
        logger.info("Put Event-object");
        gigaSpace.write(event);
    }

    @Override
    public Event get(int eventId) {
        logger.info("Get Event-object with id: " + eventId);

        Event template = new Event();
        template.setId(eventId);
        Event event = gigaSpace.readIfExists(template);

        logger.info("Return Event-object");

        return event;
    }

    @Override
    public void remove(int eventId) {
        logger.info("Remove Event-object with id: " + eventId);
        Event template = new Event();
        template.setId(eventId);
        gigaSpace.clear(template);
    }
}
