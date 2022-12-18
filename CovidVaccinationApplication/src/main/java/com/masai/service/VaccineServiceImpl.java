package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineException;
import com.masai.model.CurrentAdminSession;
import com.masai.model.Vaccine;
import com.masai.repository.AdminSessionDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;
import com.masai.repository.VaccinationCenterDao;
import com.masai.repository.VaccineDao;
import com.masai.repository.VaccineInventoryDao;

@Service
public class VaccineServiceImpl implements VaccineService{
	@Autowired
	private VaccineDao vdao;
	
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminSessionDao adminDao;
	
	@Autowired
	private VaccinationCenterDao vDao;
	
	@Override
	public Vaccine addVaccine(Vaccine vaccine ,String key)throws LoginException {
	
CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
		
		if(currentAdminSession.equals(null)) {
			
			throw new LoginException("Admin not logged in !");
			
		}
		
		
		Vaccine savedvaccine=vdao.save(vaccine);

		return savedvaccine;
		
	}




	@Override
	public Vaccine getVaccinByName(String vaccineName) throws VaccineException {
	
		Optional<Vaccine> v= 	vdao.findByVaccineName(vaccineName);
		
		if(!v.isPresent()) {
			throw new VaccineException("Vaccine does not present");
		}
		
		return v.get();
		
	}




	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException {
		
		
	Optional<Vaccine> v =	vdao.findById(vaccineId);
	
	return v.orElseThrow(()->new VaccineException("No vaccine present with vaccine id : "+vaccineId));
	
	}




	@Override
	public boolean deleteVaccine(Vaccine vaccine ,String key) throws VaccineException ,LoginException{
		
		
	CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
		
		if(currentAdminSession.equals(null)) {
			
			throw new LoginException("Admin not logged in !");
			
		}
		
		
	Optional<Vaccine> deletedvaccine =	Optional.empty();
		
	if(deletedvaccine.isPresent()) {
		return true;
	}else {
		throw new VaccineException("Vaccine not present with id : " + vaccine.getVaccineId());
	}
	
	}




	@Override
	public List<Vaccine> getAllVaccine() throws VaccineException {
		
		List<Vaccine> vaccines =vdao.findAll();
		
		if(vaccines.size()==0) {
			throw new VaccineException("No vaccines present in the database");
		}
		else {
			return vaccines;
		}
	}




	@Override
	public Vaccine updateVaccine(Vaccine vaccine,String key) throws VaccineException ,LoginException{
	
		
		
	CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
		
		if(currentAdminSession.equals(null)) {
			
			throw new LoginException("Admin not logged in !");
			
		}
		
		Optional<Vaccine> opt=vdao.findById(vaccine.getVaccineId());
		 if(!opt.isPresent()) {
			 throw new VaccineException("Vaccine not present with vaccine id");
		 }
		Vaccine uvaccine =opt.get();
		
		uvaccine.setVaccineId(vaccine.getVaccineId());
		uvaccine.setDescription(vaccine.getDescription());
		uvaccine.setVaccineCount(vaccine.getVaccineCount());
		uvaccine.setVaccineName(vaccine.getVaccineName());
		
		return uvaccine;
	}

}
