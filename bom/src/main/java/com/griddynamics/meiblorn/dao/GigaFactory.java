package com.griddynamics.meiblorn.dao;

import org.openspaces.core.GigaSpace;

/**
 * Factory to provide GigaSpace instance.
 *
 * @author Alex Rodin
 *         Date: 8/1/13
 *         Time: 5:58 PM
 */
public interface GigaFactory {
    /**
     * Returns GigaSpace instance.
     *
     * @return GigaSpace instance.
     */
    GigaSpace getGigaSpace();
}
