package com.griddynamics.persistency;

import com.gigaspaces.datasource.DataIterator;
import com.gigaspaces.datasource.DataSourceException;
import com.griddynamics.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.persistency.hibernate.DefaultHibernateExternalDataSource;
import org.openspaces.persistency.hibernate.iterator.DefaultListQueryDataIterator;
import org.openspaces.persistency.hibernate.iterator.DefaultScrollableDataIterator;
import org.springframework.beans.factory.annotation.Required;

public class EventHibernateExternalDataSource extends DefaultHibernateExternalDataSource {

    private String hquery;

    public String getHquery() {
        return hquery;
    }

    @Required
    public void setHquery(String hquery) {
        this.hquery = hquery;
    }

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
