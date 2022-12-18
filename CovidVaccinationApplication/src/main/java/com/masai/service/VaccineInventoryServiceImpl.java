package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineInventoryException;
import com.masai.model.CurrentAdminSession;
import com.masai.model.VaccinationCenter;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;
import com.masai.repository.VaccinationCenterDao;
import com.masai.repository.VaccineDao;
import com.masai.repository.VaccineInventoryDao;



@Service
public class VaccineInventoryServiceImpl implements VaccinationInventoryService{

	@Autowired
	private VaccineInventoryDao vaccineInventoryDao;
	@Autowired
	private VaccineDao vaccineDao;
	//@Autowired
	//private VaccineDao vaccineDao;
	@Autowired
	private VaccinationCenterDao vaccinationCenterDao;
	
	
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminSessionDao adminDao;
	
	
	@Override
	public List<VaccineInventory> allVaccineInventory() throws VaccineInventoryException{
		
		List<VaccineInventory> vaccineInventoryList = vaccineInventoryDao.findAll();
		
		if(vaccineInventoryList.isEmpty()) {
			throw new VaccineInventoryException("no vaccine found..");
		}
		return vaccineInventoryList;
	}

	@Override
	public VaccineInventory getVaccineInventoryByCenter(int centerId) throws VaccineInventoryException {
		
		Optional<VaccineInventory> optionalInventory = vaccineInventoryDao.findById(centerId);
		
		if(optionalInventory.isPresent()) {
			VaccineInventory vaccineInventoryFound = optionalInventory.get();
			return vaccineInventoryFound;
		}else {
			throw new VaccineInventoryException("not found with centerId :"+centerId);
		}
		
	}

	@Override
	public VaccineInventory addVaccine(VaccineInventory vaccineInventory ,Integer id,Integer vcid ,String key) throws VaccineInventoryException ,LoginException{
		
		CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
		
		if(currentAdminSession.equals(null)) {
			
			throw new LoginException("Admin not logged in !");
			
		}
		

	Optional<Vaccine> opt=	vaccineDao.findById(id);
Optional<VaccinationCenter> vc=vaccinationCenterDao.findById(vcid);
	
		vaccineInventory.setVaccine(opt.get());
		
		return	vaccineInventoryDao.save(vaccineInventory);
		
		
		
		 
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineInventory,String key) throws VaccineInventoryException,LoginException {
       
CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
		
		if(currentAdminSession.equals(null)) {
			
			throw new LoginException("Admin not logged in !");
			
		}
		
		Optional<VaccineInventory> existingOptional =  vaccineInventoryDao.findById(vaccineInventory.getInventoryId());
		
		if(existingOptional.isPresent()) {
			VaccineInventory existingInventory = existingOptional.get();
			vaccineInventoryDao.save(existingInventory);
			
			return existingInventory;
		}
		
		throw new VaccineInventoryException("Unable to update because vaccineInventory not present with Id :"+vaccineInventory.getInventoryId());
	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory vaccineInventory ,String key) throws VaccineInventoryException ,LoginException{
		
CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
		
		if(currentAdminSession.equals(null)) {
			
			throw new LoginException("Admin not logged in !");
			
		}
		
		Optional<VaccineInventory> existingOptional =  vaccineInventoryDao.findById(vaccineInventory.getInventoryId());
		
		if(existingOptional.isPresent()) {
			VaccineInventory existingInventory = existingOptional.get();
			vaccineInventoryDao.delete(existingInventory);
			
			return true;
		}
		
		throw new VaccineInventoryException("not available with InventoryId :"+vaccineInventory.getInventoryId());
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date) throws VaccineInventoryException {
		
		return null;
	}

	@Override
	public List<VaccineInventory> getVaccineInventory(Vaccine vaccine) throws VaccineInventoryException {

		List<VaccineInventory> inventories = vaccineInventoryDao.findAll();
//		List<VaccineInventory> inventories = vaccineInventoryDao.findByVaccine();
		List<VaccineInventory> allInventory = new ArrayList<>();


		
		for (VaccineInventory vaccineInventory : inventories) {
			if(vaccineInventory.getVaccine().getVaccineName().equals(vaccine.getVaccineName())) {
				allInventory.add(vaccineInventory);
			}
			
			
			
		}
		
		if(allInventory.isEmpty()) {
			throw new VaccineInventoryException("No inventory with vaccineName :"+vaccine.getVaccineName());
		}
		
		return allInventory;

	}

}
