package com.mustream.app.services.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustream.api.ApiResponseMessage;
import com.mustream.app.services.search.SearchApiService;

import com.mustream.api.NotFoundException;
import com.mustream.integration.ServiceLoader;
import com.mustream.integration.StreamingService;
import com.mustream.models.Track;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public class SearchApiServiceImpl extends SearchApiService {
    
    @Override
    public Response search(String query, SecurityContext securityContext)
    throws NotFoundException {
        List<Track> results = new ArrayList<>();
        for (StreamingService s:
                ServiceLoader.getInstance().getServices()) {
            results.addAll(s.search(query));
        }

        // Just for pretty printing ... will be deleted
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Response.ok().entity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(results)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // Here is the true version
        // return Response.ok().entity(results).build();

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
}
