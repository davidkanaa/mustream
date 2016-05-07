package com.mustream.integration;

import com.mustream.models.Track;

import java.util.List;

/**
 * Created by davidkanaa on 16-04-28.
 */
public abstract class StreamingService {

    protected String name;
    protected String baseURL;
    protected String clientID;

    public abstract List<Track> search(String terms);
    public abstract List<Track> getTracks(List<String> ids);
}
