package com.heejea.simple.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heejea.simple.domain.Member;
import com.heejea.simple.repository.MemberRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberQuery implements GraphQLQueryResolver{
	
	private final MemberRepository memberRepository;
	
	public Member findMembers(String memberId) {

		List<Member> members = memberRepository.findAll();
		Member member = new Member();
		for(Member newMember : members) {
			if(newMember.getMemberid().equals(memberId)) {
				member = memberRepository.findById(newMember.getMembersn())
						.orElse(null);
			}
		}
		return member;
//		return MemberDto.fromMember(member);
	}
	
	public List<Member> allFindMembers(){
		
		List<Member> member = memberRepository.findAll();
		
		return member;
//		return MemberDto.fromMemberList(member);
	}
}
