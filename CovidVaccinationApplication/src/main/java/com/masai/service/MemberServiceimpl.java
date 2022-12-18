package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.MemberException;
import com.masai.model.CurrentUserSession;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.IdCardDao;
import com.masai.repository.MemberDao;
import com.masai.repository.UserDao;
import com.masai.repository.VaccineRegistrationDao;

@Service
public class MemberServiceimpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private IdCardDao idCardDao;
	
	@Autowired
	private VaccineRegistrationDao vaccineRegistrationDao;
	
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Member addMember(Member member ,Long phone ,String key)throws LoginException {
		
		CurrentUserSession userCurrent=currentUserSessionDao.findByUuid(key);
		if(userCurrent.equals(null)) {
			
			throw new LoginException("User not logged in");
		}
		Optional<VaccineRegistration> optphone = vaccineRegistrationDao.findById(phone);
		member.setVaccineRegistration(optphone.get());
		return	memberDao.save(member);
	}

	@Override
	public Member getMemberById(Integer id)throws MemberException {
		
		
		Optional<Member> opt = memberDao.findById(id);
		
		if(!opt.isPresent()) {
			throw new MemberException("No Member present with id : "+id);
		}
		Member m=opt.get();
		return m;
		
	}

	@Override
	public Member getMemberByAdharNo(Long adharNo) throws MemberException{
		// TODO Auto-generated method stub
		
	Optional<IdCard> id=	idCardDao.getMemberByAdharNo(adharNo);
	if(!id.isPresent()) {
		throw new MemberException("No Member present with Adharcard number : "+adharNo);
	}
		return id.get().getMember();
	
	
	
	}

	@Override
	public Member getMemberByPanNo(String panno) throws MemberException{
		Optional<IdCard> id=	idCardDao.getMemberByPanCardNo(panno);
		if(!id.isPresent()) {
			throw new MemberException("No Member present with Pancard number : "+panno);
		}
		return id.get().getMember();
		
	}

	@Override
	public List<Member> getAllMembers() throws MemberException {
	
		List<Member> members=memberDao.findAll();
		
		return members;
		
		
	}



}
