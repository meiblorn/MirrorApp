package com.griddynamics.meiblorn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class EventObjectController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void putEventObject(ModelMap modelMap) {
        modelMap.addAttribute("text", "default text");
    }

    @RequestMapping(value = "/put/{id}/{message}", method = RequestMethod.GET)
    public void putEventObject(@PathVariable int id, @PathVariable String message,
                               ModelMap modelMap) {
        modelMap.addAttribute("text", "put " + id + " " + message);
    }
}
