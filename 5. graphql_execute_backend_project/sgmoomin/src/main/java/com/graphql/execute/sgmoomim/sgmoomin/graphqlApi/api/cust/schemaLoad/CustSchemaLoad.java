package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.schemaLoad;

import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.datafetcher.CustDataFetcher;
import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.datafetcher.CustListDataFetcher;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustSchemaLoad {

    private final CustDataFetcher custDataFetcher;
    private final CustListDataFetcher custListDataFetcher;


    public RuntimeWiring buildContractSchema(){
        return RuntimeWiring.newRuntimeWiring()
                .scalar(ExtendedScalars.GraphQLLong)
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("cust", custDataFetcher)
                        .dataFetcher("custList", custListDataFetcher)
                )                        
                .build();
    }
}
