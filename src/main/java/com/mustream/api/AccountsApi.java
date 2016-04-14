package com.mustream.api;

import com.mustream.app.factories.AccountsApiServiceFactory;
import com.mustream.api.models.Credentials;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/accounts")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the accounts API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class AccountsApi {
    private final AccountsApiService delegate = AccountsApiServiceFactory.getAccountsApi();

    @POST
    @Path("/authenticate")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Authenticate a user against the data base of user accounts.", notes = "Authenticates and returns a token.", response = String.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = " Authentication successful. Returns an access token that can be used for later authentication.", response = String.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid information supplied.", response = String.class)})
    public Response accountsAuthenticatePost(
            @ApiParam(value = "Client Identifier.", required = true) @QueryParam("client_id") String clientId,
            @ApiParam(value = "Authentication information.", required = true) Credentials credentials,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.accountsAuthenticatePost(clientId, credentials, securityContext);
    }
}
