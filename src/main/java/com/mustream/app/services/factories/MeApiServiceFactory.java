package com.mustream.app.services.factories;

import com.mustream.api.services.MeApiService;
import com.mustream.app.services.impl.MeApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class MeApiServiceFactory {

    private final static MeApiService service = new MeApiServiceImpl();

    public static MeApiService getMeApi() {
        return service;
    }
}
