package com.be.axa.drm.convention;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.UUID;
import java.io.File;
import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */
    @FunctionName("create")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.POST},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<DistributorModel>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processyed a request.");
    
        DistributorModel output = null;
        // Parse query parameter
        //String distributorid = request.getQueryParameters().get("distributorid");
        //String conventionid  = request.getQueryParameters().get("conventionid");
       // String processid  = request.getQueryParameters().get("processid");
       // String type  = request.getQueryParameters().get("type");

       DistributorModel jsonObject = request.getBody().get();
       DrmDao dao = new DrmDao();    

         try {

            jsonObject.setId(UUID.randomUUID().toString());
            output = dao.createItem(jsonObject);

         }catch(Exception exception){
            exception.printStackTrace();
         }

        return request.createResponseBuilder(HttpStatus.OK).body(output.getId()).build();
     
    }
}
