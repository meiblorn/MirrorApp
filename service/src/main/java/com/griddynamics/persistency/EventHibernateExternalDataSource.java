package com.griddynamics.persistency;

import com.gigaspaces.datasource.DataIterator;
import com.gigaspaces.datasource.DataSourceException;
import com.griddynamics.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.persistency.hibernate.DefaultHibernateExternalDataSource;
import org.openspaces.persistency.hibernate.iterator.DefaultListQueryDataIterator;
import org.openspaces.persistency.hibernate.iterator.DefaultScrollableDataIterator;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @since 1.0
 */
public class EventHibernateExternalDataSource extends DefaultHibernateExternalDataSource {

    private String hquery;

    /**
     * Returns the Hibernate Query string, which using in initial load process.
     *
     * @return the Hibernate Query.
     */
    public String getHquery() {
        return hquery;
    }

    /**
     * Sets the Hibernate Query, which using in initial load process.
     *
     * @param hquery the Hibernate Query.
     */
    @Required
    public void setHquery(String hquery) {
        this.hquery = hquery;
    }

    /**
     * Returns <tt>DataIterator</tt>, which performs the initial load operation.
     *
     * @return <tt>DataIterator</tt> instance.
     * @throws DataSourceException thrown in case of an external data source failure.
     */
    @Override
    public DataIterator initialLoad() throws DataSourceException {

        DataIterator[] iterators = new DataIterator[1];

        int from = -1;
        int size = -1;

        iterators[0] = new DefaultScrollableDataIterator(
                hquery,
                getSessionFactory(),
                getFetchSize(),
                from,
                size
        );

        return createInitialLoadIterator(iterators);
    }
}
