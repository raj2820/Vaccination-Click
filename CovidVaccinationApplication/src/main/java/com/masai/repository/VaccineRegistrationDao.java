package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.VaccineRegistration;

@Repository
public interface VaccineRegistrationDao extends JpaRepository<VaccineRegistration, Integer> {

	public VaccineRegistration findByMobileno(long mobileno);

}