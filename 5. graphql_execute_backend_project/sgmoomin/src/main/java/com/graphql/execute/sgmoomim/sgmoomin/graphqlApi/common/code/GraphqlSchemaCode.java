package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.code;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public enum GraphqlSchemaCode {  
    CUST_GRAPHQL("G1", "cust", "cust.graphqls"),
    CONTRACT_GRAPHQL("G2", "contract", "contract.graphqls");
    
    private String code;
    private String value;
    private String url;
    
    GraphqlSchemaCode(String code, String value, String url) {
        this.code = code;
        this.value = value;
        this.url = url;
    }
    
    public String getValue(){
        return this.value;
    }
    
    public String getUrl(){
        return this.url;
    } 
    
    public Resource getResource() {
        String staticUrl = "graphql/";
        return new ClassPathResource(staticUrl + this.url);
    }
    
}

