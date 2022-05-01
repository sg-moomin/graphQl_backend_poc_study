package com.heejea.simple.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AccessLevel;
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
@Entity(name="member")
public class Member{
    
	@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int membersn;
    
    @Column(nullable = false)    
    private String memberid;
    
    @Column(nullable = false)
    private String memberemail;
    
    @Column(nullable = false)
    private String membernumber;
	
//    @OneToMany
//    @JoinColumn(name = "memberSn")
//    private List<Member> members;
}
