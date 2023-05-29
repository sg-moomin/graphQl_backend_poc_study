package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.execute;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.exception.GraphqlExceuteException;

import graphql.ExecutionResult;
import graphql.GraphQL;

public class GraphqlExecute extends GraphqlExceuteException{
    /*
    * 전달 받은 schema(query)에 대해 실행시킨다.
    * */
    public ExecutionResult GraphQlExecute(GraphQL graphQL, String query) throws Exception {
        ExecutionResult executionResult = graphQL.execute(query);
        return getErrorMsg(executionResult);
    }
 
}
