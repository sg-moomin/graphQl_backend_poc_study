package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.common.code;

public enum GraphqlErrorCode{
    NullExceptionMsg("실행값이 없습니다."),
    SchemaBuildingExceptionMsg("일치하는 스키마 파일이 없습니다.");

    private String msg;

	public String getMsg(){
		return this.msg;
	}
	
	private GraphqlErrorCode(String msg) {
		this.msg = msg;
	}	
}