package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.VaccinationCenterException;
import com.masai.model.VaccinationCenter;
import com.masai.service.VaccinationCenterService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterService vaccinationCenterService;
	
	@PostMapping("/vcregister")
	public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) throws VaccinationCenterException{
		
		VaccinationCenter vc =	vaccinationCenterService.addVaccineCenter(vaccinationCenter);
		
		return new ResponseEntity<VaccinationCenter>(vc,HttpStatus.CREATED);
	}
	
	
}
