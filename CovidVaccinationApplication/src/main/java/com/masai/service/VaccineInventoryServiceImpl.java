package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccineInventoryException;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;
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
	public VaccineInventory addVaccine(VaccineInventory vaccineInventory ,Integer id) throws VaccineInventoryException {
		
	Optional<Vaccine> opt=	vaccineDao.findById(id);

		vaccineInventory.setVaccine(opt.get());
		
		return	vaccineInventoryDao.save(vaccineInventory);
		
		
		
		 
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineInventory) throws VaccineInventoryException {
        Optional<VaccineInventory> existingOptional =  vaccineInventoryDao.findById(vaccineInventory.getInventoryId());
		
		if(existingOptional.isPresent()) {
			VaccineInventory existingInventory = existingOptional.get();
			vaccineInventoryDao.save(existingInventory);
			
			return existingInventory;
		}
		
		throw new VaccineInventoryException("Unable to update because vaccineInventory not present with Id :"+vaccineInventory.getInventoryId());
	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory vaccineInventory) throws VaccineInventoryException {
		
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

//	@Override
//	public List<VaccineInventory> getVaccineInventory(Vaccine vaccine) throws VaccineInventoryException {
//		
//		return null;
//	}

}
