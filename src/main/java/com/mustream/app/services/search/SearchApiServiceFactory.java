package com.mustream.app.services.search;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public class SearchApiServiceFactory {

   private final static SearchApiService service = new SearchApiServiceImpl();

   public static SearchApiService getSearchApi()
   {
      return service;
   }
}
