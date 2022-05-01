package com.heejea.simple.graphql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heejea.simple.domain.Member;
import com.heejea.simple.dto.MemberDto;
import com.heejea.simple.repository.MemberRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberMutation implements GraphQLMutationResolver {

	private final MemberRepository memberRepository;
	
	public Member registerMember(int memberSn, String memberId, String memberEmail, String memberNumber) {
		
		Member newMember = Member.builder()
				.membersn(memberSn)
				.memberid(memberId)
				.memberemail(memberEmail)
				.membernumber(memberNumber).build();
		
		return memberRepository.save(newMember);
//		return MemberDto.fromMember(newMember);
	}

	
	public Boolean deleteMember(String memberId) {
		List<Member> memberList = memberRepository.findAll();
		int deleteChk = 0;
		
		for(Member member : memberList) {
			if(member.getMemberid().equals(memberId)) {
				memberRepository.delete(member);
				deleteChk += 1;
			}
		}
		
		if(deleteChk > 0) {
			return true;
		} else {
			return false;			
		}
	}

}
