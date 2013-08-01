package com.griddynamics.meiblorn;

import com.griddynamics.meiblorn.dao.EventDaoImpl;
import com.griddynamics.meiblorn.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/pu.xml")
public class EventDaoImplTest {

    @Autowired
    GigaSpace gigaSpace;

    @Autowired
    EventDaoImpl eventDao;

    @Before
    @After
    public void clearSpace() {
        gigaSpace.clear(null);
    }

    @Test
    public void testReadById() {
        int id = 4;
        String message = "readById put message";
        Event localEvent = new Event(id, message);
        eventDao.put(localEvent);
        Event recievedEvent = gigaSpace.readById(Event.class, id);

        assertNotNull("No object was processed", recievedEvent);
        assertEquals("Event id's not equals", localEvent.getId(), recievedEvent.getId());
        assertEquals("Event messages not equals", localEvent.getMessage(), recievedEvent.getMessage());
    }

    @Test
    public void testPut() throws Exception {

        int id = 1;
        String message = "put message";
        Event localEvent = new Event(id, message);
        eventDao.put(localEvent);
        Event recievedEvent = gigaSpace.read(
                new SQLQuery<Event>(Event.class, "id = " + id));

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
    public void testGetAll() throws Exception {

        int count = 10;
        String prefix = "Id: ";



        List<Event> localEventList = new ArrayList<Event>();
        for (int i = 0; i < count; i++) {
            Event event = new Event(i, prefix + i);
            localEventList.add(event);
            gigaSpace.write(event);
        }

        List<Event> recievedEventList = eventDao.getAll();
        Collections.sort(recievedEventList, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        for (int i = 0; i < count; i++) {
            Event localEvent = localEventList.get(i);
            Event recievedEvent = recievedEventList.get(i);
            assertNotNull("No object was processed", recievedEvent);
            assertEquals("Event id's not equals", localEvent.getId(), recievedEvent.getId());
            assertEquals("Event messages not equals", localEvent.getMessage(), recievedEvent.getMessage());
        }
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
