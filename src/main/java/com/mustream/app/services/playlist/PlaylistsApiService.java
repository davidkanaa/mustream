package com.mustream.app.services.playlist;

import com.mustream.api.NotFoundException;
import com.mustream.models.PlaylistInfo;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public abstract class PlaylistsApiService {
  
      public abstract Response addTrackstoPlaylist(String playlistId,List<String> uris,SecurityContext securityContext)
      throws NotFoundException;
  
      public abstract Response createPlaylist(PlaylistInfo playlistInfo, SecurityContext securityContext)
      throws NotFoundException;
  
      public abstract Response deletePlaylist(String playlistId,SecurityContext securityContext)
      throws NotFoundException;
  
      public abstract Response getAllPlaylists(String group,SecurityContext securityContext)
      throws NotFoundException;
  
      public abstract Response getPlaylist(String playlistId,SecurityContext securityContext)
      throws NotFoundException;
  
      public abstract Response removeTracksfromPlaylist(String playlistId,List<String> uris,SecurityContext securityContext)
      throws NotFoundException;
  
      public abstract Response updatePlaylist(String playlistId,String name,SecurityContext securityContext)
      throws NotFoundException;
  
}
