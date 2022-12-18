package com.masai.service;

import com.masai.exception.IdCardException;
import com.masai.model.IdCard;

public interface IdCardService {

	
	public IdCard getPanCardByNumber(String panNo) throws IdCardException;
	
//	public IdCard getAadharCardNumber(Long aadharNo) throws IdCardException;
	
	public IdCard addIdCard(IdCard idcard ,Integer id); 
}
