package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.contract.schemaLoad;

import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.contract.datafetcher.ContractFetcher;

import graphql.schema.DataFetcher;
import graphql.schema.idl.RuntimeWiring;

@Component
public class ContractSchemaLoad {

    private ContractFetcher contractFetcher;


    public RuntimeWiring buildContractSchema(){
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("contractList", (DataFetcher) contractFetcher)
                ).build();
    }
}
