package com.masai.service;

import com.masai.model.Member;

public interface MemberService {
	

	
public Member addMember(Member member,Long phone) ; 

public Member getMemberById(Integer id);

public Member getMemberByAdharNo(Long adharNo);

public Member getMemberByPanNo(String panno);
}
