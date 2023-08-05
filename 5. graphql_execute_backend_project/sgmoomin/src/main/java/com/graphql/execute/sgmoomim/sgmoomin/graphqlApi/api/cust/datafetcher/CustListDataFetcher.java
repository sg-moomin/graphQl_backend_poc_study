package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.datafetcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.entity.Cust;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustListDataFetcher implements DataFetcher<List<Cust>> {

    @Override
    public List<Cust> get(DataFetchingEnvironment dataFetchingEnvironment) {
        List<Cust> custList = new ArrayList<>();

        custList.add(Cust.builder()
                .custSeq(1L)
                .buyQty(1L)
                .useDist("사용").build());

        custList.add(Cust.builder()
                .custSeq(2L)
                .buyQty(2L)
                .useDist("미사용").build());

        custList.add(Cust.builder()
                .custSeq(3L)
                .buyQty(3L)
                .useDist("사용").build());

        return custList;
    }
}
 

