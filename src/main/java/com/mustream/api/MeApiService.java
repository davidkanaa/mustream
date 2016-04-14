package com.mustream.api;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public abstract class MeApiService {
    public abstract Response meGet(String accessToken, SecurityContext securityContext)
            throws NotFoundException;
}
