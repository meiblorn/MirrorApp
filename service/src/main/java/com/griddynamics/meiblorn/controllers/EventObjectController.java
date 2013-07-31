package com.griddynamics.meiblorn.controllers;

import com.griddynamics.meiblorn.dao.EventDaoImpl;
import com.griddynamics.meiblorn.dao.NoSuchEventException;
import com.griddynamics.meiblorn.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public @ResponseBody
    Event putEvent(@ModelAttribute("event") Event event) {
        eventDao.put(event);
        return event;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeEvent(@PathVariable int id) throws NoSuchEventException {
        eventDao.remove(id);
        return "redirect:/";
    }
}
