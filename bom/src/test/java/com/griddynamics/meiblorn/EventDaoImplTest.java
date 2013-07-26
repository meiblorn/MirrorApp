package com.griddynamics.meiblorn;

import com.griddynamics.meiblorn.dao.implementation.EventDaoImpl;
import com.griddynamics.meiblorn.domain.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventDaoImplTest {

    @Ignore
    @Before @After
    public void clearSpace() {

    }

    @Ignore("not ready yet")
    @Test
    public void processingTest() {
        EventDaoImpl eventDao = new EventDaoImpl();

        int id = 1;
        String message = "test message";
        Event event = new Event(id, message);

        //TODO: add asserts
        eventDao.put(event);
        eventDao.get(id);
        eventDao.remove(id);
    }
}
