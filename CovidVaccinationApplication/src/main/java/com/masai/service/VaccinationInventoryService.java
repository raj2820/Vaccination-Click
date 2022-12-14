package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineInventoryException;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;



public interface VaccinationInventoryService {
	
	public List<VaccineInventory> allVaccineInventory()throws VaccineInventoryException;
	
	public VaccineInventory getVaccineInventoryByCenter(int CenterId)throws VaccineInventoryException;
	
public VaccineInventory addVaccine(VaccineInventory vaccineInventory,Integer id ,Integer vcid,String key)throws VaccineInventoryException,LoginException;
	
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineInventory,String key)throws VaccineInventoryException ,LoginException;
	
	public boolean deleteVaccineInventory(VaccineInventory vaccineInventory,String key)throws VaccineInventoryException ,LoginException;
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date)throws VaccineInventoryException;
	
	public List<VaccineInventory> getVaccineInventory(Vaccine vaccine)throws VaccineInventoryException;

	
}
