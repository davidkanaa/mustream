package com.mustream.api.controllers;

import com.mustream.processes.exceptions.NotFoundException;
import com.mustream.api.services.UsersApiService;
import com.mustream.app.services.factories.UsersApiServiceFactory;
import com.mustream.api.models.Playlist;
import com.mustream.api.models.User;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/users")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class UsersApi {
    private final UsersApiService delegate = UsersApiServiceFactory.getUsersApi();

    @POST
    @Path("/{user_id}/playlists/{playlist_id}/tracks")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Add one or more tracks a user\u2019s playlist", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = void.class)})
    public Response addTrackstoPlaylist(
            @ApiParam(value = "Authentication token.", required = true) @HeaderParam("access_token") String accessToken,
            @ApiParam(value = "Identifier of the user.", required = true) @PathParam("user_id") String userId,
            @ApiParam(value = "Identifier of the user's playlist.", required = true) @PathParam("playlist_id") String playlistId,
            @ApiParam(value = "The Mustream Resource Identifier or URI for the tracks to add to the playlist.") List<String> uris,
            @ApiParam(value = "The Mustream Resource Identifier or URI for the tracks to add to the playlist.") @QueryParam("uris") List<String> uris2,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.addTrackstoPlaylist(accessToken, userId, playlistId, uris, uris2, securityContext);
    }

    @POST
    @Path("/{user_id}/playlists")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Create a playlist for a Mustream user", notes = "Returns a reference to the freshly created ``Playlist`` object.", response = Playlist.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Playlist.class)})
    public Response createPlaylist(
            @ApiParam(value = "Authentication token", required = true) @HeaderParam("access_token") String accessToken,
            @ApiParam(value = "identifier of the user", required = true) @PathParam("user_id") String userId,
            @ApiParam(value = "The name of the new playlist.", required = true) String name,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createPlaylist(accessToken, userId, name, securityContext);
    }

    @DELETE
    @Path("/{user_id}/playlists/{playlist_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Delete a user's playlist", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = void.class)})
    public Response deletePlaylist(
            @ApiParam(value = "Authentication token", required = true) @HeaderParam("access_token") String accessToken,
            @ApiParam(value = "identifier of the user", required = true) @PathParam("user_id") String userId,
            @ApiParam(value = "identifier of the user's playlist", required = true) @PathParam("playlist_id") String playlistId,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePlaylist(accessToken, userId, playlistId, securityContext);
    }

    @GET
    @Path("/{user_id}/playlists")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get the playlists of a Mustream user.", notes = "Gets `Playlist` objects.", response = Playlist.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Playlist.class, responseContainer = "List")})
    public Response getAllPlaylists(
            @ApiParam(value = "Authentication token", required = true) @HeaderParam("access_token") String accessToken,
            @ApiParam(value = "Identifier of the user", required = true) @PathParam("user_id") String userId,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getAllPlaylists(accessToken, userId, securityContext);
    }

    @GET
    @Path("/{user_id}/playlists/{playlist_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get a playlist owned by a Mustream user", notes = "Get a `Playlist` object.", response = Playlist.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Playlist.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = Playlist.class)})
    public Response getPlaylist(
            @ApiParam(value = "Authentication token", required = true) @HeaderParam("access_token") String accessToken,
            @ApiParam(value = "identifier of the user", required = true) @PathParam("user_id") String userId,
            @ApiParam(value = "identifier of the user's playlist", required = true) @PathParam("playlist_id") String playlistId,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getPlaylist(accessToken, userId, playlistId, securityContext);
    }

    @GET
    @Path("/{user_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get public profile information about a Mustream user.", notes = "Gets the `User` objects with **user_id** as identifier value.", response = User.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response.", response = User.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "User not found.", response = User.class)})
    public Response getUser(
            @ApiParam(value = "User identifier", required = true) @PathParam("user_id") String userId,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getUser(userId, securityContext);
    }

    @DELETE
    @Path("/{user_id}/playlists/{playlist_id}/tracks")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Remove one or more tracks from a user\u2019s playlist", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = void.class)})
    public Response removeTracksfromPlaylist(
            @ApiParam(value = "Authentication token", required = true) @HeaderParam("access_token") String accessToken,
            @ApiParam(value = "Identifier of the user", required = true) @PathParam("user_id") String userId,
            @ApiParam(value = "Identifier of the user's playlist", required = true) @PathParam("playlist_id") String playlistId,
            @ApiParam(value = "The Mustream Resource Identifier or URI for the tracks to remove to the playlist.") List<String> uris,
            @ApiParam(value = "The Mustream Resource Identifier or URI for the tracks to remove to the playlist.") @QueryParam("uris") List<String> uris2,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.removeTracksfromPlaylist(accessToken, userId, playlistId, uris, uris2, securityContext);
    }

    @PUT
    @Path("/{user_id}/playlists/{playlist_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Rename user's playlist", notes = "", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found schema: $ref: ", response = void.class)})
    public Response updatePlaylist(
            @ApiParam(value = "Authentication token", required = true) @HeaderParam("access_token") String accessToken,
            @ApiParam(value = "Identifier of the user", required = true) @PathParam("user_id") String userId,
            @ApiParam(value = "Identifier of the user's playlist", required = true) @PathParam("playlist_id") String playlistId,
            @ApiParam(value = "The new name of the playlist.", required = true) String name,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updatePlaylist(accessToken, userId, playlistId, name, securityContext);
    }
}
