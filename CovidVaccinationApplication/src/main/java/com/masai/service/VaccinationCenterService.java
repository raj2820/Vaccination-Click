package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.VaccinationCenterException;
import com.masai.model.VaccinationCenter;

public interface VaccinationCenterService {
	
	public List<VaccinationCenter> getAllVaccineCenter()throws VaccinationCenterException;
	
    public VaccinationCenter getVaccineCenter(Integer code)throws VaccinationCenterException;
	
	public List<VaccinationCenter> getVaccineCenterByState(String state)throws VaccinationCenterException;
	
	public List<VaccinationCenter> getVaccineCenterByCity(String city)throws VaccinationCenterException;
	
	public VaccinationCenter  addVaccineCenter(VaccinationCenter vaccineCenter ,String key)throws LoginException;
	
	public VaccinationCenter updateVaccineCenter(VaccinationCenter vaccineCenter,String key)throws VaccinationCenterException,LoginException;
	
	public boolean deleteVaccineCenter(Integer code,String key)throws VaccinationCenterException,LoginException;

}
