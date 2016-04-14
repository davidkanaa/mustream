package com.mustream.api;

import com.mustream.api.models.Track;
import com.mustream.app.factories.SearchApiServiceFactory;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/search")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the search API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class SearchApi {
    private final SearchApiService delegate = SearchApiServiceFactory.getSearchApi();

    @GET

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get all integrated streaming services catalog information about tracks that match a keyword string.", notes = "Gets ``Track`` objects.", response = Track.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Track.class, responseContainer = "List")})
    public Response search(
            @ApiParam(value = "terms to search", required = true) @QueryParam("query") String query,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.search(query, securityContext);
    }
}
