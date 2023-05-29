package com.graphql.execute.sgmoomim.sgmoomin.graphqlApi.contract.entity;


import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;



@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class contract {

    @Id
    private Long prodSeq;
    private String prodName;

}
