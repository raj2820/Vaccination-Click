package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.repository.MemberDao;

@Service
public class MemberServiceimpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member addMember(Member member) {
		IdCard id=new IdCard();
		id.setMember(member);
		
		return	memberDao.save(member);
	}
	
	

}
