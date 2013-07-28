package com.griddynamics.meiblorn;

import com.griddynamics.meiblorn.dao.EventDaoImpl;
import com.griddynamics.meiblorn.domain.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/pu.xml")
public class EventDaoImplTest {

    @Autowired
    GigaSpace gigaSpace;

    EventDaoImpl eventDao = new EventDaoImpl();

    @Before
    @After
    public void clearSpace() {
        gigaSpace.clear(null);
    }

    @Test
    public void testPut() throws Exception {

        int id = 1;
        String message = "put message";
        Event localEvent = new Event(id, message);

        eventDao.put(localEvent);
        Event recievedEvent = gigaSpace.readById(Event.class, id);

        assertNotNull("No object was processed", recievedEvent);
        assertEquals("Event id's not equals", localEvent.getId(), recievedEvent.getId());
        assertEquals("Event messages not equals", localEvent.getMessage(), recievedEvent.getMessage());
    }

    @Test
    public void testGet() throws Exception {

        int id = 2;
        String message = "get message";

        Event localEvent = new Event(id, message);
        gigaSpace.write(localEvent);

        Event recievedEvent = eventDao.get(id);
        assertNotNull("No object was processed", recievedEvent);
        assertEquals("Event id's not equals", localEvent.getId(), recievedEvent.getId());
        assertEquals("Event messages not equals", localEvent.getMessage(), recievedEvent.getMessage());
    }

    @Test
    public void testRemove() throws Exception {
        int id = 3;
        String message = "remove message";

        Event localEvent = new Event(id, message);
        gigaSpace.write(localEvent);
        eventDao.remove(id);

        assertNull("Object was processed", gigaSpace.read(localEvent));
    }
}
