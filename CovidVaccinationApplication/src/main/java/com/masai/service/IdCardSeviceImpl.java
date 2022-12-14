package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.IdCardException;
import com.masai.exception.LoginException;
import com.masai.model.AadharCard;
import com.masai.model.CurrentUserSession;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.PanCard;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.IdCardDao;
import com.masai.repository.MemberDao;
import com.masai.repository.UserDao;




@Service
public class IdCardSeviceImpl implements IdCardService{
	
	@Autowired
	private IdCardDao idCardDao;
	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminDao adminDao;
	

	@Override
	public PanCard getPanCardByNumber(String panNo) throws IdCardException {
		
		
		Optional<IdCard> idCard = idCardDao.getMemberByPanCardNo(panNo);
		
		if(idCard.isEmpty()) {
			throw new IdCardException("Invalid Pan Card Number");
		}
		
		PanCard panCard = idCard.get().getPanCard();
		
		return panCard;
		
	}

	@Override
	public AadharCard getAadharCardNumber(Long aadharNo) throws IdCardException {
		
		Optional<IdCard> idCard = idCardDao.getMemberByAdharNo(aadharNo);
		
		if(idCard.isEmpty()) {
			throw new IdCardException("Invalid Aadhar Card Number");
		}
		
		AadharCard aadhar = idCard.get().getAdharcard();
		
		return aadhar;
		
	}

	

	
	@Override
	public IdCard addIdCard(IdCard idcard, Integer id ,String key)throws LoginException {
		CurrentUserSession userCurrent=currentUserSessionDao.findByUuid(key);
		if(userCurrent.equals(null)) {
			
			throw new LoginException("User not logged in");
		}
	Optional<Member> m=	mdao.findById(id);
	
	idcard.setMember(m.get());	
	
	return idCardDao.save(idcard);
		
		
	}

}
