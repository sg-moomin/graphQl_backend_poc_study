package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.exception;

import org.springframework.stereotype.Component;

import com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.code.GraphqlErrorCode;


import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GraphqlExceuteException {
    /*
    * ExecutionResult 결과에 따른 Exception 처리
    * */
    public ExecutionResult getErrorMsg(ExecutionResult executionResult) throws Exception {
        try{
            if(executionResult != null){
                if(!executionResult.getErrors().isEmpty()) {
                    String errorMsg = executionResult.getErrors().toString();
                    throw new Exception(errorMsg);
                } else {
                    return executionResult;
                }
            } else {
                throw new Exception(GraphqlErrorCode.NullExceptionMsg.getMsg());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
     }
}
