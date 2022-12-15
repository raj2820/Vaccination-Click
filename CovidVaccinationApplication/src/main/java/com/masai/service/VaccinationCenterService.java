package com.masai.service;

import java.util.List;

import com.masai.exception.VaccinationCenterException;
import com.masai.model.VaccinationCenter;

public interface VaccinationCenterService {
	
	
public VaccinationCenter getVaccineCenter(Integer code)throws VaccinationCenterException;
	
	public List<VaccinationCenter> getVaccineCenterByState(String state)throws VaccinationCenterException;
	
	public List<VaccinationCenter> getVaccineCenterByCity(String city)throws VaccinationCenterException;
	
	public VaccinationCenter  addVaccineCenter(VaccinationCenter vaccineCenter);
	
	public VaccinationCenter updateVaccineCenter(VaccinationCenter vaccineCenter)throws VaccinationCenterException;
	
	public boolean deleteVaccineCenter(VaccinationCenter vaccineCenter);

}
