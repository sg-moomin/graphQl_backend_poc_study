package com.heejea.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heejea.simple.domain.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {

}
