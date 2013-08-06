package com.griddynamics.factories;

import com.griddynamics.dao.GigaFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * GigaSpace factory implementation.
 *
 * @author Alex Rodin
 *         Date: 8/1/13
 *         Time: 6:03 PM
 */
@Component
public class GigaFactoryImpl implements GigaFactory, ServletContextAware {
    private GigaSpace gigaSpace;
    private ServletContext servletContext;

    /**
     * TODO:Complete
     * @return
     */
    @Override
    public GigaSpace getGigaSpace() {
        if (gigaSpace == null) {
            gigaSpace = (GigaSpace) servletContext.getAttribute("gigaSpace");
        }
        return gigaSpace;
    }

    /**
     * TODO:Completes
     * @param servletContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
