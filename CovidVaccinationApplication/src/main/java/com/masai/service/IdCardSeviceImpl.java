package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.IdCardException;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.repository.IdCardDao;
import com.masai.repository.MemberDao;




@Service
public class IdCardSeviceImpl implements IdCardService{
	
	@Autowired
	private IdCardDao idCardDao;
	@Autowired
	private MemberDao mdao;

	@Override
	public IdCard getPanCardByNumber(String panNo) throws IdCardException {
		
		List<IdCard> cardList = idCardDao.findAll();
//		boolean flag = false;
		
		for(IdCard id : cardList) {
			if(id.getPanCard().equals(panNo)) {
//				flag=true;
				return id;
			}
		}
	
		
		throw new IdCardException("Please provide correct panNumber");
		
	}

//	@Override
//	public IdCard getAadharCardNumber(Long aadharNo) throws IdCardException {
//		
//		List<IdCard> cardList = idCardDao.findAll();
//		
//		for(IdCard id : cardList) {
//			if(id.getAadharNo().equals(aadharNo)) {
//
//				return id;
//			}
//		}
//		
//		throw new IdCardException("Please provide correct addharNumber");
//		
//	}

	

	
	@Override
	public IdCard addIdCard(IdCard idcard, Integer id) {
	Optional<Member> m=	mdao.findById(id);
	
	idcard.setMember(m.get());	
	
	return idCardDao.save(idcard);
		
		
	}

}
