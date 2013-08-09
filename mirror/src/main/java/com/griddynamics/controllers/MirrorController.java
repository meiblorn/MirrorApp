package com.griddynamics.controllers;

import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * URL: /operation
 *
 * @since 1.0
 */
@Controller
@RequestMapping(value = "operation", produces = MediaType.APPLICATION_JSON_VALUE)
public class MirrorController implements ServletContextAware {

    ServletContext servletContext;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public String getStatus() throws SQLException {
        DriverManagerDataSource dataSource =
                (DriverManagerDataSource) servletContext.getAttribute("dataSource");
        return null;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
