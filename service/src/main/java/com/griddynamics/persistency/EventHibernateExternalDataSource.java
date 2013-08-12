package com.griddynamics.persistency;

import com.gigaspaces.datasource.DataIterator;
import com.gigaspaces.datasource.DataSourceException;
import com.griddynamics.domain.Event;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.persistency.hibernate.DefaultHibernateExternalDataSource;
import org.openspaces.persistency.hibernate.iterator.DefaultListQueryDataIterator;

public class EventHibernateExternalDataSource extends DefaultHibernateExternalDataSource {
    @Override
    public DataIterator initialLoad() throws DataSourceException {
        DataIterator[] iterators = new DataIterator[1];

        iterators[0] = new DefaultListQueryDataIterator(
                new SQLQuery<Event>(Event.class, "id is NOT null"),
                getSessionFactory(),
                getFetchSize(),
                getInitialLoadChunkSize());

        return createInitialLoadIterator(iterators);
    }
}
