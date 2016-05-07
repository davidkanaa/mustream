package com.mustream.integration;

import com.mustream.integration.services.SoundCloud;
import com.mustream.integration.services.Spotify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidkanaa on 16-04-28.
 */
public class ServiceLoader {

    private static ServiceLoader instance;
    private Map<String, StreamingService> services;

    /**
     * @return The sole instance of the service services.
     */
    public static ServiceLoader getInstance() {

        if (instance == null) {
            instance = new ServiceLoader();
            instance.init();
        }

        return instance;
    }

    /**
     *
     */
    private void init() {

        // create the HashMap to hold the streaming services.
        services = new HashMap<>();

        // loads services.
        services.put("spotify", new Spotify());
        services.put("soundcloud", new SoundCloud());

    }

    /**
     * @return The list of available (integrated) streaming services.
     */
    public List<StreamingService> getServices() {
        return new ArrayList<>(services.values());
    }

    public StreamingService getService(String serviceId) {
        return services.get(serviceId);
    }

    /**
     * Loads a service into the service services.
     *
     * @param s The StreamingService associated with the service provider we want to add.
     * @return This instance of the service register.
     */
    public void loadService(StreamingService s) {}
}
