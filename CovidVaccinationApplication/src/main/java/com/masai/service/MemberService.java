package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.MemberException;
import com.masai.model.Member;

public interface MemberService {
	
public List<Member> getAllMembers() throws MemberException;
	
public Member addMember(Member member,Long phone ,String key) throws LoginException ; 

public Member getMemberById(Integer id) throws MemberException;

public Member getMemberByAdharNo(Long adharNo)throws MemberException;

public Member getMemberByPanNo(String panno)throws MemberException;


}
