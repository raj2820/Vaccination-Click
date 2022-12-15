package com.masai.service;

import java.util.List;

import com.masai.exception.VaccineException;
import com.masai.model.Vaccine;

public interface VaccineService {

	public Vaccine getVaccinByName(String vaccineName);
//	
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException;

	public Vaccine addVaccine(Vaccine vaccine) throws VaccineException;
	
//	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException;
//	
	public boolean deleteVaccine(Vaccine vaccine) throws VaccineException;
//
	public List<Vaccine> getAllVaccine() throws VaccineException;
	
	
}
