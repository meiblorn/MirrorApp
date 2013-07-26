package com.griddynamics.meiblorn;

import com.griddynamics.meiblorn.dao.implementation.EventDaoImpl;
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

import javax.naming.Context;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
public class EventDaoImplTest {

    //@Autowired
    //GigaSpace gigaSpace;

    @Ignore
    @Before @After
    public void clearSpace() {

    }

    //@Ignore("not ready yet")
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
