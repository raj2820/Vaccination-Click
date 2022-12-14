package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.VaccineInventoryException;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;


public interface VaccineInventoryService {
	
    //public List<Vaccine> allVaccineInventory()throws VaccineInventoryException;
	
	public VaccineInventory getVaccineInventoryByCenter(int CenterId)throws VaccineInventoryException;
	
	public VaccineInventory addVaccineCount(VaccineInventory vaccineInventory)throws VaccineInventoryException;
	
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineInventory)throws VaccineInventoryException;
	
	public boolean deleteVaccineInventory(VaccineInventory vaccineInventory)throws VaccineInventoryException;
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date)throws VaccineInventoryException;
	
	public List<VaccineInventory> getVaccineInventory(Vaccine vaccine)throws VaccineInventoryException;


}
