package com.griddynamics.controllers;

import com.griddynamics.dao.impl.EventDaoImpl;
import com.griddynamics.dao.NoSuchEventException;
import com.griddynamics.domain.Event;
import com.griddynamics.domain.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO:Complete
 */
@Controller
@RequestMapping(value = "operation", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventObjectController {
    @Autowired
    private EventDaoImpl eventDao;

    /**
     * TODO:Complete
     * @return
     */
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Events retrieveAll() {
        return new Events(eventDao.getAll());
    }

    /**
     * TODO:Complete
     * @param id
     * @return
     * @throws NoSuchEventException
     */
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Event getEventObject(@PathVariable int id) throws NoSuchEventException {
            return eventDao.get(id);
    }

    /**
     * TODO:Complete
     * @param event
     * @return
     */
    @RequestMapping(value = "/event", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Event putEvent(@RequestBody Event event) {
        eventDao.put(event);
        return event;
    }

    /**
     * TODO:Complete
     * @param id
     * @return
     * @throws NoSuchEventException
     */
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Integer removeEvent(@PathVariable int id) throws NoSuchEventException {
        eventDao.remove(id);
        return id;
    }
}
