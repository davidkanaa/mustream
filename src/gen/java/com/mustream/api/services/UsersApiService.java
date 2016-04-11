package com.mustream.api.services;

import com.mustream.api.exceptions.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public abstract class UsersApiService {
    public abstract Response addTrackstoPlaylist(String accessToken, String userId, String playlistId, List<String> uris, List<String> uris2, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response createPlaylist(String accessToken, String userId, String name, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deletePlaylist(String accessToken, String userId, String playlistId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getAllPlaylists(String accessToken, String userId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getPlaylist(String accessToken, String userId, String playlistId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getUser(String userId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response removeTracksfromPlaylist(String accessToken, String userId, String playlistId, List<String> uris, List<String> uris2, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response updatePlaylist(String accessToken, String userId, String playlistId, String name, SecurityContext securityContext)
            throws NotFoundException;
}
