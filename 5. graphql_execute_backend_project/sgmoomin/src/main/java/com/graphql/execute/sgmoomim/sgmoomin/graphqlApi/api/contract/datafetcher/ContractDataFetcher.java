package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.contract.datafetcher;

import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.contract.entity.Contract;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ContractDataFetcher implements DataFetcher<Contract>{

    @Override
    public Contract get(DataFetchingEnvironment environment) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }


}


