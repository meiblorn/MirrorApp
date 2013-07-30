package com.griddynamics.meiblorn.controllers;

import com.griddynamics.meiblorn.dao.EventDaoImpl;
import com.griddynamics.meiblorn.dao.NoSuchEventException;
import com.griddynamics.meiblorn.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class EventObjectController {

    EventDaoImpl eventDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexView() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("event", new Event());
        return modelAndView;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getRedirect(@ModelAttribute("event") Event event) {
        return "redirect:get/" + event.getId();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ModelAndView getEventObject(@PathVariable int id) throws NoSuchEventException {
        ModelAndView modelAndView = new ModelAndView("event");
        Event event = eventDao.get(id);
        modelAndView.addObject("event", event);
        return modelAndView;
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String putEvent(@ModelAttribute("event") Event event) {
        ModelAndView modelAndView = new ModelAndView("event");
        eventDao.put(event);
        return "redirect:get/" + event.getId();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void removeEvent(@ModelAttribute("event") Event event, ModelMap modelMap) throws NoSuchEventException {
        eventDao.remove(event.getId());
    }
}
