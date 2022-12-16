package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.VaccineException;
import com.masai.model.Vaccine;

public interface VaccineDao extends JpaRepository<Vaccine, Integer>{
	public Optional<Vaccine> findByVaccineName(String Name) throws VaccineException;
}
