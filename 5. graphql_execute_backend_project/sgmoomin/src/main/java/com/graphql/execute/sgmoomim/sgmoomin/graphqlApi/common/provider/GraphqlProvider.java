package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.provider;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.code.GraphqlSchemaCode;
import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.execute.GraphqlExecuteSchema;

import graphql.GraphQL;

@Component
public class GraphqlProvider {
    private GraphqlExecuteSchema graphqlExecuteSchema;
 
    private Resource resource;
 
    public GraphqlProvider(GraphqlExecuteSchema graphqlExecuteSchema){
        this.graphqlExecuteSchema = graphqlExecuteSchema;
    }
    /**
     * mapping url에 따른 스키마 load -> 로직 처리를 위해
     * */
    public GraphQL 
    loadSchema(String mappingUrlValue) throws IOException {
        return graphqlExecuteSchema.loadGraphqlSchema(this.getResource(mappingUrlValue), mappingUrlValue);
    }
 
    /**
     * graphqls 파일 위치 및 리소스 생성
     * */
    public Resource getResource(String mappingUrlValue){
        if(mappingUrlValue == GraphqlSchemaCode.CUST_GRAPHQL.getValue()){
            return GraphqlSchemaCode.CUST_GRAPHQL.getResource();
        } else if (mappingUrlValue == GraphqlSchemaCode.CONTRACT_GRAPHQL.getValue()) {
            return GraphqlSchemaCode.CONTRACT_GRAPHQL.getResource();
        } else {
            return null;
        }
    }
}
