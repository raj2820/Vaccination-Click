package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.IdCardException;
import com.masai.model.IdCard;
import com.masai.repository.IdCardDao;




@Service
public class IdCardSeviceImpl implements IdCardService{
	
	@Autowired
	private IdCardDao idCardDao;

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
	public IdCard addIdCard(IdCard idCard) throws IdCardException {
		
		if(idCard!=null) {
			idCardDao.save(idCard);
			
			return idCard;
		}
		
		throw new IdCardException("Please provide allDetails");
	}

}
