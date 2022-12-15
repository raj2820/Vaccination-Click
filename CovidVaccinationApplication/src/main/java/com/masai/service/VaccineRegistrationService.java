package com.masai.service;

import java.util.List;

import com.masai.exception.VaccineRegistrationException;
import com.masai.model.VaccineRegistration;
import com.masai.model.Member;


public interface VaccineRegistrationService {


//	public VaccineRegistration getVaccineRegistration(long moblieno)throws VaccineRegistrationException;
//
//	public List<Member> getAllMemberList()throws VaccineRegistrationException;

	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg)throws VaccineRegistrationException;

//	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg)throws VaccineRegistrationException;
//
//	public boolean deleteVaccineRegistration(Integer reg)throws VaccineRegistrationException;

}