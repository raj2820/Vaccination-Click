package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.VaccineInventory;



public interface VaccineInventoryDao extends JpaRepository<VaccineInventory, Integer>{

}
