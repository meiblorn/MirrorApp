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
 *
 * Spring MVC REST Controller class that provides access to GigaSpace throw EventDao Interface.
 *
 * URL: /operation
 *
 * @since 1.0
 */
@Controller
@RequestMapping(value = "operation", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventObjectController {
    @Autowired
    private EventDaoImpl eventDao;

    /**
     * Retrieves all <tt>Event</tt> objects from the <tt>GigaSpace</tt> space.
     *
     * Methods; GET
     * URL: /event
     *
     * @return {@link Events} instance
     */
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Events retrieveAll() {
        return new Events(eventDao.getAll());
    }

    /**
     * Retrieves the <tt>Event</tt> instance with specified identification number from the <tt>GigaSpace</tt> space.
     *
     * Methods; GET
     * URL: /event/{id}
     *
     * @param id the <tt>Event</tt> object identifier.
     * @return the <tt>Event</tt> instance;
     * @throws NoSuchEventException
     */
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Event getEventObject(@PathVariable int id) throws NoSuchEventException {
            return eventDao.get(id);
    }

    /**
     * Inserts the <tt>Event</tt> object into the <tt>GigaSpace</tt> space
     *
     * Methods; POST
     * URL: /event/
     * Media types: application/json
     *
     * @param event the <tt>Event</tt> instance;
     * @return the <tt>Event</tt> instance;
     */
    @RequestMapping(value = "/event", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Event putEvent(@RequestBody Event event) {
        eventDao.put(event);
        return event;
    }

    /**
     * Removes the <tt>Event</tt> instance with specified identification number from the <tt>GigaSpace</tt> space.
     *
     * Methods; DELETE
     * URL: /event/{id}
     *
     * @param id the <tt>Event</tt> object identifier.
     * @return the <tt>Event</tt> object identifier.
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
