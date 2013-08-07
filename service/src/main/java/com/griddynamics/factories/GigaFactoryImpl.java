package com.griddynamics.factories;

import com.griddynamics.dao.GigaFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.logging.Logger;

/**
 * GigaSpace factory implementation.
 *
 * @author Alex Rodin
 *         Date: 8/1/13
 *         Time: 6:03 PM
 */
@Component
public class GigaFactoryImpl implements GigaFactory, ServletContextAware {
    Logger logger = Logger.getLogger(this.getClass().getName());
    private GigaSpace gigaSpace;
    private ServletContext servletContext;

    /**
     * TODO:Complete
     * @return
     */
    @Override
    public GigaSpace getGigaSpace() {
        if (gigaSpace == null) {
            logger.info("-----> getGigaSpace()");
            gigaSpace = (GigaSpace) servletContext.getAttribute("gigaSpace");
            logger.info("-----> gigaSpace: " + gigaSpace.toString());
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
