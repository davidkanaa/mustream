package com.mustream.app.factories;

import com.mustream.api.SearchApiService;
import com.mustream.app.impl.SearchApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class SearchApiServiceFactory {

   private final static SearchApiService service = new SearchApiServiceImpl();

   public static SearchApiService getSearchApi()
   {
      return service;
   }
}
