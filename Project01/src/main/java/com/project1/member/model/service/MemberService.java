package com.project1.member.model.service;

import com.project1.member.model.dao.MemberDAO;
import com.project1.member.model.dto.MemberDTO;

public class MemberService {

	public MemberDTO login(MemberDTO member) {
		
		MemberDTO loginMember = new MemberDAO().login(member);
		
		return loginMember;
	}
	
	
	public int signUp(MemberDTO member) {
		
		// 아이디 중복 확인
		int result = new MemberDAO().checkId(member.getMemberId());

		if(result > 0) {
			return result;
		}
		
		new MemberDAO().signUp(member);
		return result;
	}
}
