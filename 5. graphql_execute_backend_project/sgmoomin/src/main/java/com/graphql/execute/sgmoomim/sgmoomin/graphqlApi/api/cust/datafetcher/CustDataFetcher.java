package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.datafetcher;


import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.entity.Cust;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustDataFetcher implements DataFetcher<Cust> {
 
    @Override
    public Cust get(DataFetchingEnvironment dataFetchingEnvironment) {
        Long custSeq = dataFetchingEnvironment.getArgument("custSeq");
        return new Cust(1L, 1L, "사용");
    }
}

