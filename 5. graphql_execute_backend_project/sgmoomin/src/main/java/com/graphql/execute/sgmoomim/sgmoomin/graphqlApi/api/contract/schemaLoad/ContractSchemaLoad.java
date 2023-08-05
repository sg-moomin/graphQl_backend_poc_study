package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.contract.schemaLoad;

import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.contract.datafetcher.ContractDataFetcher;

import graphql.schema.DataFetcher;
import graphql.schema.idl.RuntimeWiring;

@Component
public class ContractSchemaLoad {

    private ContractDataFetcher contractFetcher;


    public RuntimeWiring buildContractSchema(){
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("contract", (DataFetcher) contractFetcher)
                ).build();
    }
}
