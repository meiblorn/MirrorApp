package com.griddynamics.meiblorn.controllers;

import com.griddynamics.meiblorn.dao.EventDaoImpl;
import com.griddynamics.meiblorn.dao.NoSuchEventException;
import com.griddynamics.meiblorn.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class EventObjectController {

    @Autowired
    EventDaoImpl eventDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexView() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<Event> eventList = eventDao.getAll();

        modelAndView.addObject("formEvent", new Event());
        modelAndView.addObject("eventList", eventList);

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
    public String putEvent(@ModelAttribute("formEvent") Event event, HttpServletRequest httpServletRequest) {
        eventDao.put(event);
        return "redirect:" + httpServletRequest.getHeader("Referer");
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeEvent(@PathVariable int id, HttpServletRequest httpServletRequest) throws NoSuchEventException {
        eventDao.remove(id);
        return "redirect:" + httpServletRequest.getHeader("Referer");
    }

    @ExceptionHandler(NoSuchEventException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandler(HttpServletRequest httpServletRequest,
                                   HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        return "redirect:" + httpServletRequest.getHeader("Referer");
    }
}
