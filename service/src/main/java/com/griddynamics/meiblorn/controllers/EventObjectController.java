package com.griddynamics.meiblorn.controllers;

import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventObjectController {

    private GigaSpace gigaSpace;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexView() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ModelAndView getEventObject(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("text", "GetHello");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void putEventObject() {

    }
}
