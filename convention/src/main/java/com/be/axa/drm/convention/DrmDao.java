package com.be.axa.drm.convention;

import java.util.ArrayList;
import java.util.List;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientException;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.implementation.Utils;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.FeedResponse;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.azure.cosmos.models.FeedOptions;

public class DrmDao {


    private final String databaseName = "drm";
    private final String containerName = "drm";

    private CosmosDatabase database;
    private CosmosContainer container;
    
    // The Cosmos DB Client
    private static CosmosClient cosmosClient = CosmosClientFactory.getCosmosClient();

    private static final ObjectMapper OBJECT_MAPPER = Utils.getSimpleObjectMapper();


    public DistributorModel createItem(DistributorModel m) {

  
        CosmosContainerProperties containerProperties =
        new CosmosContainerProperties(containerName, "/distributorid");
        //model output = null;
        DistributorModel jsonResponse = null;
        
      try {
        database = cosmosClient.createDatabaseIfNotExists(databaseName).getDatabase();
        container = database.createContainerIfNotExists(containerProperties, 400).getContainer();

        //CosmosItemRequestOptions cosmosItemRequestOptions = new CosmosItemRequestOptions(m.getDistributorid());
       //model createdModel = container.createItem(m).getResource();
       jsonResponse = container.createItem(m).getResource();
       
      }
      catch(Exception e){
          e.printStackTrace();
      }

      return jsonResponse;
    }

    public List<DistributorModel> getItem(String id) {

      CosmosContainerProperties containerProperties =
      new CosmosContainerProperties(containerName, "/distributorid");
      List<DistributorModel> modelItems = new ArrayList<DistributorModel>();    	

      
    try {
      database = cosmosClient.createDatabaseIfNotExists(databaseName).getDatabase();
      container = database.createContainerIfNotExists(containerProperties, 400).getContainer();

      //CosmosItemRequestOptions cosmosItemRequestOptions = new CosmosItemRequestOptions(m.getDistributorid());
     //model createdModel = container.createItem(m).getResource();
      String sql = "SELECT * FROM root r WHERE r.id='"+id+"'";     
      FeedOptions options = new FeedOptions();

      for (FeedResponse<JsonNode> pageResponse: 

              container.queryItems(sql, options,JsonNode.class)
                    .iterableByPage()) {

                //options.setRequestContinuation(pageResponse.getContinuationToken());

                for (JsonNode item : pageResponse.getElements()) {
                    
                    try {
                      modelItems.add(OBJECT_MAPPER.treeToValue(item, DistributorModel.class));
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                  }
        }
                      

    }
    catch(Exception e){
        e.printStackTrace();
    }

    return modelItems;
  }

}