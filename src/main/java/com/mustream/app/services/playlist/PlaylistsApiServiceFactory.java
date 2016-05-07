package com.mustream.app.services.playlist;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public class PlaylistsApiServiceFactory {

   private final static PlaylistsApiService service = new PlaylistsApiServiceImpl();

   public static PlaylistsApiService getPlaylistsApi()
   {
      return service;
   }
}
