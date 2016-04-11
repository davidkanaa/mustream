package com.mustream.app.services.impl;

import com.mustream.processes.exceptions.NotFoundException;
import com.mustream.api.models.Credentials;
import com.mustream.api.services.AccountsApiService;
import com.mustream.processes.utils.ApiResponseMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class AccountsApiServiceImpl extends AccountsApiService {
    @Override
    public Response accountsAuthenticatePost(String clientId, Credentials credentials, SecurityContext securityContext)
            throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
