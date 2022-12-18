package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.VaccineRegistration;
import com.masai.model.Member;


public interface VaccineRegistrationService {


	public VaccineRegistration getVaccineRegistration(long moblieno)throws VaccineRegistrationException;
//
	public List<Member> getAllMemberList()throws VaccineRegistrationException;

	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg,String key )throws VaccineRegistrationException ,LoginException;

	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg)throws VaccineRegistrationException;
//
	public boolean deleteVaccineRegistration(Long mobile)throws VaccineRegistrationException;

}