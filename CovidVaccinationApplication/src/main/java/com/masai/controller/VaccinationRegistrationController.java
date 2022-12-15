package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.VaccineRegistrationException;
import com.masai.model.VaccineRegistration;
import com.masai.service.VaccineRegistrationService;

@RestController
public class VaccinationRegistrationController {

	@Autowired
	private VaccineRegistrationService vaccineRegistrationService;
	
	@PostMapping("/register")
	public ResponseEntity<VaccineRegistration> addvaccineRegistrationHandler(VaccineRegistration vaccineRegistration) throws VaccineRegistrationException{
		
		
		VaccineRegistration registered = vaccineRegistrationService.addVaccineRegistration(vaccineRegistration);
		
		return new ResponseEntity<VaccineRegistration>(registered,HttpStatus.CREATED);
	}
	
}
