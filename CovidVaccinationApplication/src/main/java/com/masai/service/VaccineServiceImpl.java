package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccineException;
import com.masai.model.Vaccine;
import com.masai.repository.VaccineDao;
import com.masai.repository.VaccineInventoryDao;

@Service
public class VaccineServiceImpl implements VaccineService{
	@Autowired
	private VaccineDao vdao;
	
	
	
	
	@Override
	public Vaccine addVaccine(Vaccine vaccine) {
		Vaccine savedvaccine=vdao.save(vaccine);
//		VaccineCount count=vaccine.getVaccineCount();
//		count.setVaccine(savedvaccine);
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
	public boolean deleteVaccine(Vaccine vaccine) throws VaccineException {
		
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

}
