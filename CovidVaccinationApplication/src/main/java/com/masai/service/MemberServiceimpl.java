package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.repository.IdCardDao;
import com.masai.repository.MemberDao;

@Service
public class MemberServiceimpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private IdCardDao idCardDao;
	@Override
	public Member addMember(Member member) {
	
		
		return	memberDao.save(member);
	}

	@Override
	public Member getMemberById(Integer id) {
		
		
		Optional<Member> opt = memberDao.findById(id);
		Member m=opt.get();
		return m;
		
	}

	@Override
	public Member getMemberByAdharNo(Long adharNo) {
		// TODO Auto-generated method stub
		
	Optional<IdCard> id=	idCardDao.getMemberByAdharNo(adharNo);
		return id.get().getMember();
	
	
	
	}

	@Override
	public Member getMemberByPanNo(String panno) {
		Optional<IdCard> id=	idCardDao.getMemberByPanCardNo(panno);
		return id.get().getMember();
		
	}


}
