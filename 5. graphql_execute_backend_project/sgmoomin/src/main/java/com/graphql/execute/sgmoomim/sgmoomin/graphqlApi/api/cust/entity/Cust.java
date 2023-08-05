package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.cust.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cust {

    // @Id
    private Long custSeq;
    private Long buyQty;
    private String useDist;
    public class builder {
    }

}
