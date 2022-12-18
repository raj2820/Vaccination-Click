package com.masai.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Member;
import com.masai.model.User;
import com.masai.model.VaccineRegistration;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.MemberDao;
import com.masai.repository.UserDao;
import com.masai.repository.VaccineRegistrationDao;


@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{
	
	@Autowired
	private VaccineRegistrationDao vaccineRegistrationDao;

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public VaccineRegistration getVaccineRegistration(long mobileno) throws VaccineRegistrationException {
		VaccineRegistration vaccineRegistration = vaccineRegistrationDao.findByMobileno(mobileno);
		if (vaccineRegistration != null) {
			return vaccineRegistration;
		} else {
			throw new VaccineRegistrationException("No Vaccine Registration found with mobileno "+mobileno);
		}
		
	}

	@Override
	public List<Member> getAllMemberList() throws VaccineRegistrationException {
	
		List<Member> member = memberDao.findAll();

		if (member.size() == 0) {
			throw new VaccineRegistrationException("No memeber Found");
		} else {
			return member;
		}
	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg ,String key ) throws VaccineRegistrationException,LoginException {
		

		CurrentUserSession userCurrent=currentUserSessionDao.findByUuid(key);
		if(userCurrent.equals(null)) {
			
			throw new LoginException("User not logged in");
		}
		
		
		VaccineRegistration addVaccineRegistration = vaccineRegistrationDao.save(reg);

		return addVaccineRegistration;
	}
	
//
	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException {
		Optional<VaccineRegistration> opt = vaccineRegistrationDao.findById(reg.getMobileno());
		if (opt.isPresent()) {
			VaccineRegistration updatedVaccineRegs = vaccineRegistrationDao.save(reg);
			return updatedVaccineRegs;
		} else {
			throw new VaccineRegistrationException("Invalid Vaccine Registration ");
		}
	}

	@Override
	public boolean deleteVaccineRegistration(Long mobile) throws VaccineRegistrationException {
		Optional<VaccineRegistration> opt = vaccineRegistrationDao.findById(mobile);
		if (!opt.isPresent()) {
			throw new RuntimeException("Not able to access");
		} else {
			VaccineRegistration vaccineRegestration = vaccineRegistrationDao.findById(mobile)
					.orElseThrow(() -> new VaccineRegistrationException("Vaccine Registration not found"));
			
			vaccineRegistrationDao.delete(vaccineRegestration);
			return true;
		} 
	}
	

}

