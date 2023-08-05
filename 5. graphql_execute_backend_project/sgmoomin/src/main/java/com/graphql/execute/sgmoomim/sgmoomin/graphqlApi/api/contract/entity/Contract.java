package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.api.contract.entity;


// import javax.persistence.Id;

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
public class Contract {

    // @Id
    private Long prodSeq;
    private String prodName;

}
