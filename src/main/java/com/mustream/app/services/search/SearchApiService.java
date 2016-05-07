package com.mustream.app.services.search;

import com.mustream.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public abstract class SearchApiService {
  
      public abstract Response search(String query,SecurityContext securityContext)
      throws NotFoundException;
  
}
