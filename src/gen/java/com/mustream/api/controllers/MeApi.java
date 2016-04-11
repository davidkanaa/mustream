package com.mustream.api.controllers;

import com.mustream.api.exceptions.NotFoundException;
import com.mustream.models.User;
import com.mustream.api.services.MeApiService;
import com.mustream.api.factories.MeApiServiceFactory;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/me")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the me API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class MeApi {
    private final MeApiService
            delegate = MeApiServiceFactory.getMeApi();

    @GET

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get detailed profile information about the current user.", notes = "Gets the `User` object corresponding to the current user profile.", response = User.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response.", response = User.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid token supplied.", response = User.class)})
    public Response meGet(
            @ApiParam(value = "Authentication token", required = true) @HeaderParam("access_token") String accessToken,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.meGet(accessToken, securityContext);
    }
}
