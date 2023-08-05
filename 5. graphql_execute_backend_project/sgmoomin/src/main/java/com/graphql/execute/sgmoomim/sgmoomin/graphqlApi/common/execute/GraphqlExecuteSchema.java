package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.execute;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.contract.schemaLoad.ContractSchemaLoad;
import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.schemaLoad.CustSchemaLoad;
import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.code.GraphqlErrorCode;
import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.code.GraphqlSchemaCode;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphqlExecuteSchema {
    private final ContractSchemaLoad contractSchema;
    private final CustSchemaLoad custSchemaLoad;
 
    public GraphqlExecuteSchema(ContractSchemaLoad contractSchema, CustSchemaLoad custSchemaLoad){
        this.contractSchema = contractSchema;
        this.custSchemaLoad = custSchemaLoad;
    }
 
    /*
    * 스키마 파일(graphqls)을 load하는 로직
    * */
    public GraphQL loadGraphqlSchema(Resource resource, String mappingUrlValue) throws IOException{
        System.out.println("resource" + resource);
        System.out.println("mappingUrlValue" + mappingUrlValue);
        
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring buildRuntimeWiring = this.getRuntimeWiring(mappingUrlValue);
        if(buildRuntimeWiring == null){
            throw new IOException(GraphqlErrorCode.SchemaBuildingExceptionMsg.getMsg());
        }
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, buildRuntimeWiring);
        return GraphQL.newGraphQL(schema).build();
    }
 
    /*
     * graphqls 파일 내 설정된 스키마들에 대해 datafetcher와 연결
     * */
    public RuntimeWiring getRuntimeWiring(String mappingUrlValue){
        if(mappingUrlValue == GraphqlSchemaCode.CUST_GRAPHQL.getValue()){
            return custSchemaLoad.buildContractSchema();
        } else if (mappingUrlValue == GraphqlSchemaCode.CONTRACT_GRAPHQL.getValue()) {
            return contractSchema.buildContractSchema();
        } else {
            return null;
        }
    }
}
