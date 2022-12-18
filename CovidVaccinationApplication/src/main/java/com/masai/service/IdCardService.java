package com.masai.service;

import com.masai.exception.IdCardException;
import com.masai.exception.LoginException;
import com.masai.model.AadharCard;
import com.masai.model.IdCard;
import com.masai.model.PanCard;

public interface IdCardService {

	
	public PanCard getPanCardByNumber(String panNo) throws IdCardException;
	
	public AadharCard getAadharCardNumber(Long aadharNo) throws IdCardException;
	
	public IdCard addIdCard(IdCard idcard ,Integer id,String key)throws LoginException; 
}
