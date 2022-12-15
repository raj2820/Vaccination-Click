package com.masai.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccineRegistrationException;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;
import com.masai.repository.MemberDao;
import com.masai.repository.VaccineRegistrationDao;


@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{
	
	@Autowired
	private VaccineRegistrationDao vaccineRegistrationDao;

	@Autowired
	private MemberDao memberDao;

//	@Override
//	public VaccineRegistration getVaccineRegistration(long mobileno) throws VaccineRegistrationException {
//		VaccineRegistration vaccineRegistration = vaccineRegistrationDao.findByMobileno(mobileno);
//		if (vaccineRegistration != null) {
//			return vaccineRegistration;
//		} else {
//			throw new VaccineRegistrationException("No Vaccine Registration found with mobileno "+mobileno);
//		}
//		
//	}

//	@Override
//	public List<Member> getAllMemberList() throws VaccineRegistrationException {
//	
//		List<Member> member = memberDao.findAll();
//
//		if (member.size() == 0) {
//			throw new VaccineRegistrationException("No memeber Found");
//		} else {
//			return member;
//		}
//	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException {
		

		VaccineRegistration addVaccineRegistration = vaccineRegistrationDao.save(reg);

		return addVaccineRegistration;
	}
	
//
//	@Override
//	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException {
//		Optional<VaccineRegistration> opt = vaccineRegistrationDao.findById(reg.getRegistrationNo());
//		if (opt.isPresent()) {
//			VaccineRegistration updatedVaccineRegs = vaccineRegistrationDao.save(reg);
//			return updatedVaccineRegs;
//		} else {
//			throw new VaccineRegistrationException("Invalid Vaccine Registration ");
//		}
//	}

//	@Override
//	public boolean deleteVaccineRegistration(Integer reg) throws VaccineRegistrationException {
//		Optional<VaccineRegistration> opt = vaccineRegistrationDao.findById(reg);
//		if (!opt.isPresent()) {
//			throw new RuntimeException("Not able to access");
//		} else {
//			VaccineRegistration vaccineRegestration = vaccineRegistrationDao.findById(reg)
//					.orElseThrow(() -> new VaccineRegistrationException("Vaccine Registration not found"));
//			
//			vaccineRegistrationDao.delete(vaccineRegestration);
//			return true;
//		} 
//	}

	

}

