package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.masai.model.VaccineInventory;



@Repository
public interface VaccineInventoryDao extends JpaRepository<VaccineInventory, Integer>{

	
}
