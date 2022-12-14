package com.masai.service;

import java.util.List;

import com.masai.model.VaccinationCenter;

public interface VaccinationCenterService {
	
	
	public List<VaccinationCenter> getVaccineCenter(Integer code);
	
	public VaccinationCenter addVaccineCenter(VaccinationCenter vaccine);
	
	public VaccinationCenter updateVaccineCenter(VaccinationCenter vaccine);
	
	public boolean deleteVaccineCenter(VaccinationCenter vaccine);
	
	

}
