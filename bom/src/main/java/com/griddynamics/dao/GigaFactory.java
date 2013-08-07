package com.griddynamics.dao;

import org.openspaces.core.GigaSpace;

/**
 * Factory interface, that provides GigaSpace instance.
 *
 * @author Alex Rodin
 *         Date: 8/1/13
 *         Time: 5:58 PM
 *
 * @since 1.0
 */
public interface GigaFactory {
    /**
     * Returns <tt>GigaSpace</tt> instance.
     *
     * @return <tt>GigaSpace</tt> instance.
     */
    GigaSpace getGigaSpace();
}
