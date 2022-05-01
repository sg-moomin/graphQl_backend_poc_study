package com.heejea.simple.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.heejea.simple.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private int memberSn;
	private String memberId;
	private String memberEmail;
	private String memberNumber;
	
	public static MemberDto fromMember(Member member) {
		return MemberDto.builder()
				.memberSn(member.getMembersn())
				.memberId(member.getMemberid())
				.memberEmail(member.getMemberemail())
				.memberNumber(member.getMembernumber())
				.build();
		
	}
	
	public static List<MemberDto> fromMemberList(Collection<Member> members) {
		return members.stream().map(MemberDto::fromMember).collect(Collectors.toList());
	}
}
