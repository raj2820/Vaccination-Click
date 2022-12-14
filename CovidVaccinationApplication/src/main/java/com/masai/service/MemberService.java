package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.MemberException;
import com.masai.model.Member;

@Service
public interface MemberService {

	
	
	
	
	public Member getMemberById(Integer memberid)throws MemberException;
	
	public Member getMemberByAdharcardNo(long aharno)throws MemberException;
	
	public Member getMemberByPanNo(Integer panno )throws MemberException;
	
	public Member registerMember(Member member) ;
	
	public Member updateMember(Member member)throws MemberException;
	
	public Member deleteMember(Member member)throws MemberException;
	
	
	
	
}
