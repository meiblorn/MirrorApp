package com.griddynamics.meiblorn.controllers;

import com.griddynamics.meiblorn.dao.AlreadyInSpaceException;
import com.griddynamics.meiblorn.dao.EventDaoImpl;
import com.griddynamics.meiblorn.dao.NoSuchEventException;
import com.griddynamics.meiblorn.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
@RequestMapping(value = "/")
public class EventObjectController {

    @Autowired
    EventDaoImpl eventDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexView() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("event", new Event());
        return modelAndView;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ModelAndView getEventObject(@PathVariable int id) throws NoSuchEventException {
        ModelAndView modelAndView = new ModelAndView("event");
        Event event = eventDao.get(id);
        modelAndView.addObject("event", event);
        return modelAndView;
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public @ResponseBody Event putEvent(@ModelAttribute("event") Event event) throws AlreadyInSpaceException {
        eventDao.put(event);
        return event;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeEvent(@PathVariable int id) throws NoSuchEventException {
        eventDao.remove(id);
        return "redirect:/";
    }

    @ExceptionHandler (Exception.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllExceptions(Exception ex) {
        return new ModelAndView(new MappingJacksonJsonView(), "message", ex.getMessage());
    }
}
