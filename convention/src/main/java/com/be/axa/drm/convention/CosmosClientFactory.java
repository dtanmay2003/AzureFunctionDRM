package com.be.axa.drm.convention;

import com.azure.cosmos.ConnectionPolicy;
import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;

public class CosmosClientFactory {
    private static final String HOST = "https://distributors.documents.azure.com:443/";
    private static final String MASTER_KEY = "Ji2j8hvLWGka6VwVjPv4373ljMmRzqarvcoO5shyu7NP3h0gF8f7nUXLLY4l0ULtFwvqLlUmhjSK1Lb1rxXL4g==";

    private static CosmosClient cosmosClient = new CosmosClientBuilder()
            .setEndpoint(HOST)
            .setKey(MASTER_KEY)
            .setConnectionPolicy(ConnectionPolicy.getDefaultPolicy())
            .setConsistencyLevel(ConsistencyLevel.EVENTUAL)
            .buildClient();

    public static CosmosClient getCosmosClient() {
        return cosmosClient;
    }

}