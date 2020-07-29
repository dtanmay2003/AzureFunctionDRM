package com.be.axa;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import com.be.axa.drm.convention.DistributorModel;
import com.be.axa.drm.convention.DrmDao;
import com.be.axa.drm.convention.model;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Azure Functions with HTTP Trigger.
 */
public class Read {
    /**
     * This function listens at endpoint "/api/Read". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/Read
     * 2. curl {your host}/api/Read?name=HTTP%20Query
     */
    @FunctionName("Read")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        ObjectMapper objectMapper = new ObjectMapper();
        // Parse query parameter
        String id = request.getQueryParameters().get("id");
        String json = "";
        DrmDao dao = new DrmDao();
        try {
            List<DistributorModel> outputList = dao.getItem(id);
            DistributorModel data = outputList.get(0);
            json = objectMapper.writeValueAsString(data);
        }catch(Exception e){
            e.printStackTrace();
        }
        //dynamic data = JsonCom 
        //String name = m.getName();
        return request.createResponseBuilder(HttpStatus.OK).body(json).build();
        
    }
}
