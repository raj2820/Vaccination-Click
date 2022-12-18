package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;



public interface VaccineInventoryDao extends JpaRepository<VaccineInventory, Integer>{

	
	public List<VaccineInventory> findByVaccine (Vaccine vaccine);
}
