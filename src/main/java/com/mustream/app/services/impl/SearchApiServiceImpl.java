package com.mustream.app.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustream.api.models.Track;
import com.mustream.app.services.consumers.ServiceConsumer;
import com.mustream.app.services.register.ServiceRegister;
import com.mustream.processes.exceptions.NotFoundException;
import com.mustream.api.services.SearchApiService;
import com.mustream.processes.utils.ApiResponseMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class SearchApiServiceImpl extends SearchApiService {
    @Override
    public Response search(String query, SecurityContext securityContext)
            throws NotFoundException {
        // do some magic!
        List<Track> results = new ArrayList<>();
        for (ServiceConsumer consumer:
                ServiceRegister.getInstance_().getServiceConsumers()) {
            results.addAll(consumer.search(query));
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
