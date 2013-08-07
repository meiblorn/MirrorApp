package com.griddynamics.factories;

import com.griddynamics.dao.GigaFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.logging.Logger;

/**
 * {@link GigaFactory} interface implementation. Provides <tt>GigaSpace</tt> instance throw servlet context.
 *
 * @author Alex Rodin
 *         Date: 8/1/13
 *         Time: 6:03 PM
 *
 * @since 1.0
 */
@Component
public class GigaFactoryImpl implements GigaFactory, ServletContextAware {
    Logger logger = Logger.getLogger(this.getClass().getName());
    private GigaSpace gigaSpace;
    private ServletContext servletContext;

    /**
     * Returns the <tt>GigaSpace</tt> instance.
     *
     * @return <tt>GigaSpace</tt> instance.
     */
    @Override
    public GigaSpace getGigaSpace() {
        if (gigaSpace == null) {
            gigaSpace = (GigaSpace) servletContext.getAttribute("gigaSpace");
        }
        return gigaSpace;
    }

    /**
     * Sets the servlet context.
     *
     * @param servletContext the servlet context
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
