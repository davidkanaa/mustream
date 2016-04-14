package com.mustream.app.register;

import com.mustream.app.consumers.ServiceConsumer;
import com.mustream.app.consumers.SoundCloud;
import com.mustream.app.consumers.Spotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-04-11.
 */
public class ServiceRegister {

    private List<ServiceConsumer> serviceConsumers;
    protected static ServiceRegister instance;

    private ServiceRegister(){
        serviceConsumers = new ArrayList<>();
        serviceConsumers.add(new Spotify());
        serviceConsumers.add(new SoundCloud());
    }

    /**
     *
     * @return The list of available (integrated) streaming services.
     */

    public List<ServiceConsumer> getServiceConsumers() {
        return serviceConsumers;
    }

    /**
     *
     * @return The sole instance of the service register.
     */
    public static ServiceRegister getInstance_(){

        if (instance == null){
            instance = new ServiceRegister();
        }

        return instance;
    }

    /**
     * Loads a service into the service register.
     * @param s The ServiceConsumer associated with the service provider we want to add.
     * @return This instance of the service register.
     */
    public  ServiceRegister loadService(ServiceConsumer s){
        if (!this.serviceConsumers.contains(s)) {
            serviceConsumers.add(s);
        }
        return this;
    }
}
