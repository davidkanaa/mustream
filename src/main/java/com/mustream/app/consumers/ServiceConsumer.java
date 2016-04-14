package com.mustream.app.consumers;

import com.mustream.api.models.Track;

import java.util.List;
import java.util.Objects;

/**
 * Created by davidkanaa on 16-04-11.
 */
public abstract class ServiceConsumer {

    protected String id;
    protected String name;
    protected String baseURL;
    protected String clientID;

    public abstract List<Track> search(String terms);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServiceConsumer consumer = (ServiceConsumer) obj;
        return Objects.equals(id, consumer.id) &&
                Objects.equals(name, consumer.name) &&
                Objects.equals(baseURL, consumer.baseURL);
    }
}
