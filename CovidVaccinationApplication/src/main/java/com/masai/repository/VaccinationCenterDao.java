package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.VaccinationCenter;

@Repository
public interface VaccinationCenterDao extends JpaRepository<VaccinationCenter, Integer>{

    public List<VaccinationCenter> findByState(String state);
	
	public List<VaccinationCenter> findByCity(String city);
	
	
	
}
