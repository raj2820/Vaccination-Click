package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccinationCenterException;
import com.masai.model.VaccinationCenter;
import com.masai.repository.VaccinationCenterDao;


@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{
	
	
	
	@Autowired
	private VaccinationCenterDao vDao;

	@Override
	public VaccinationCenter getVaccineCenter(Integer code) throws VaccinationCenterException {
		
		return vDao.findById(code).orElseThrow(()-> new VaccinationCenterException("Vaccination Center Not Found by this"+code));
	
	}

	@Override
	public List<VaccinationCenter> getVaccineCenterByState(String state) throws VaccinationCenterException {
        
		List<VaccinationCenter> vc=vDao.findByState(state);
		
		if(vc.isEmpty()) {
			throw new VaccinationCenterException("Vaccination Center Not Found By this"+state);
		}
		
		return vc;
		
	}

	@Override
	public List<VaccinationCenter> getVaccineCenterByCity(String city) throws VaccinationCenterException {
		 
           List<VaccinationCenter> vc=vDao.findByCity(city);
		
		if(vc.isEmpty()) {
			throw new VaccinationCenterException("Vaccination Center Not Found By this"+city);
		}
		
		return vc;
	}

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter vaccineCenter) {
		
		VaccinationCenter vc=vDao.save(vaccineCenter);
		
		return vc;
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter vaccineCenter) throws VaccinationCenterException {
         
		Optional<VaccinationCenter> opt=vDao.findById(vaccineCenter.getVaccineCode());
		
		if(opt.isPresent()) {
			VaccinationCenter updateVc=vDao.save(vaccineCenter);
			
			return updateVc;
		}else
		
		throw new VaccinationCenterException("Vaccination Center Not Found by this Id"+vaccineCenter.getVaccineCode());
		
		
	}

	@Override
	public boolean deleteVaccineCenter(VaccinationCenter vaccineCenter) {
        
		Optional<VaccinationCenter> opt=vDao.findById(vaccineCenter.getVaccineCode());
		
		if(opt.isPresent()) {
			
			VaccinationCenter vc=opt.get();
			
			vDao.delete(vc);
			
			return true;
		}
		
		return false;
	}
	
	
}
