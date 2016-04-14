package com.mustream.app.factories;

import com.mustream.api.UsersApiService;
import com.mustream.app.impl.UsersApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class UsersApiServiceFactory {

    private final static UsersApiService service = new UsersApiServiceImpl();

    public static UsersApiService getUsersApi() {
        return service;
    }
}
