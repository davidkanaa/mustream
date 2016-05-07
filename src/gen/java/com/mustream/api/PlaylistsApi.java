package com.mustream.api;

import com.mustream.models.Playlist;
import com.mustream.models.PlaylistInfo;
import com.mustream.app.services.playlist.PlaylistsApiService;
import com.mustream.app.services.playlist.PlaylistsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/playlists")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the playlists API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public class PlaylistsApi  {
   private final PlaylistsApiService delegate = PlaylistsApiServiceFactory.getPlaylistsApi();

    @POST
    @Path("/{playlist_id}/tracks")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add one or more tracks a playlist", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = void.class) })
    public Response addTrackstoPlaylist(
        @ApiParam(value = "Identifier of the playlist.",required=true) @PathParam("playlist_id") String playlistId,
        @ApiParam(value = "The Mustream Resource Identifier or URI for the tracks to add to the playlist." ,required=true) List<String> uris,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addTrackstoPlaylist(playlistId,uris,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a playlist.", notes = "Returns a reference to the freshly created ``Playlist`` object.", response = Playlist.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Playlist.class) })
    public Response createPlaylist(
        @ApiParam(value = "" ,required=true) PlaylistInfo playlistInfo,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createPlaylist(playlistInfo,securityContext);
    }
    @DELETE
    @Path("/{playlist_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a user's playlist", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = void.class) })
    public Response deletePlaylist(
        @ApiParam(value = "identifier of the playlist",required=true) @PathParam("playlist_id") String playlistId,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deletePlaylist(playlistId,securityContext);
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a list of playlists.", notes = "Gets `Playlist` objects.", response = Playlist.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Playlist.class, responseContainer = "List") })
    public Response getAllPlaylists(
        @ApiParam(value = "",required=true) @QueryParam("group") String group,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllPlaylists(group,securityContext);
    }
    @GET
    @Path("/{playlist_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a playlist owned by a Mustream user", notes = "Get a `Playlist` object.", response = Playlist.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Playlist.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = Playlist.class) })
    public Response getPlaylist(
        @ApiParam(value = "identifier of the playlist",required=true) @PathParam("playlist_id") String playlistId,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPlaylist(playlistId,securityContext);
    }
    @DELETE
    @Path("/{playlist_id}/tracks")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Remove one or more tracks from a playlist", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = void.class) })
    public Response removeTracksfromPlaylist(
        @ApiParam(value = "Identifier of the user's playlist",required=true) @PathParam("playlist_id") String playlistId,
        @ApiParam(value = "The Mustream Resource Identifier or URI for the tracks to remove to the playlist." ,required=true) List<String> uris,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.removeTracksfromPlaylist(playlistId,uris,securityContext);
    }
    @PUT
    @Path("/{playlist_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Rename user's playlist", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Playlist not found", response = void.class) })
    public Response updatePlaylist(
        @ApiParam(value = "Identifier of the playlist",required=true) @PathParam("playlist_id") String playlistId,
        @ApiParam(value = "The new name of the playlist." ,required=true) String name,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updatePlaylist(playlistId,name,securityContext);
    }
}
