package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccineInventoryException;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;
import com.masai.repository.VaccineInventoryDao;



@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService{

	@Autowired
	private VaccineInventoryDao vaccineInventoryDao;
	
//	@Autowired
//	private VaccineDao vaccineDao;
//	
//	@Override
//	public List<Vaccine> allVaccineInventory() throws VaccineException {
//		
//		List<Vaccine> vaccineList = vaccineDao.findAll();
//		
//		if(vaccineList.isEmpty()) {
//			throw new VaccineException("not found..");
//		}
//		return vaccineList;
//	}

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
	public VaccineInventory addVaccineCount(VaccineInventory vaccineInventory) throws VaccineInventoryException {
		
		return null;
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineInventory) throws VaccineInventoryException {
		
		return null;
	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory vaccineInventory) throws VaccineInventoryException {
		
		return false;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date) throws VaccineInventoryException {
		
		return null;
	}

	@Override
	public List<VaccineInventory> getVaccineInventory(Vaccine vaccine) throws VaccineInventoryException {
		
		return null;
	}

}
