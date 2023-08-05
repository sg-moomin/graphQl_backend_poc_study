package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.code.GraphqlSchemaCode;
import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.execute.GraphqlExecute;
import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.provider.GraphqlProvider;

import graphql.GraphQL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GraphqlApiController {
    /**
     * 모든 로직의 실행 단계는 아래와 같다.
     * 대상
     * contract, cust
     *
     * 처리 순서
     * 1. Mapping Url에 따라 처리 -> PostMapping
     * 2. Mapping Url에 따른 .graphqls 스키마 파일을 load 한다. -> graphqlProvider.loadSchema
     * 3. GraphQL을 실행시킨 결과 값을 return 한다
     * **/
    private GraphQL graphQL;
    private GraphqlProvider graphqlProvider;
    private GraphqlExecute graphqlExecute;
 
    @Autowired
    public GraphqlApiController(GraphqlProvider graphqlProvider, GraphqlExecute graphqlExecute) throws IOException {
        this.graphqlProvider = graphqlProvider;
        this.graphqlExecute = graphqlExecute;
    }
 
    /**
     * contract.graphqls
     *
     * */
    @PostMapping("/contract")
    // @PostMapping("/contract")
    public ResponseEntity<Object> getContractQuery(@RequestBody String query) throws Exception {
        graphQL = graphqlProvider.loadSchema(GraphqlSchemaCode.CONTRACT_GRAPHQL.getValue());
        return ResponseEntity.ok(graphqlExecute.GraphQlExecute(graphQL, query).getData());
    }
 
    /**
     * cust.graphqls
     *
     * */
    @PostMapping("/cust")
    public ResponseEntity<Object> getCustQuery(@RequestBody String query) throws Exception {
        graphQL = graphqlProvider.loadSchema(GraphqlSchemaCode.CUST_GRAPHQL.getValue());
        return ResponseEntity.ok(graphqlExecute.GraphQlExecute(graphQL, query).getData());
    }
}
