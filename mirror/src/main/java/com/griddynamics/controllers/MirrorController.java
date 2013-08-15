package com.griddynamics.controllers;

import com.griddynamics.monitor.MirrorMonitor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * URL: /
 *
 * @since 1.0
 */
@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MirrorController implements ServletContextAware {

    ServletContext servletContext;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getStatus() {
        MirrorMonitor spaceMonitor = (MirrorMonitor)
                servletContext.getAttribute("mirrorMonitor");
        return spaceMonitor.getStatus();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
