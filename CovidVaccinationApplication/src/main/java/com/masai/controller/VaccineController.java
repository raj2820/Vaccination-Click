package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Vaccine;
import com.masai.service.VaccineService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class VaccineController {
	@Autowired
	private VaccineService vService;
	
	
	@PostMapping("/vaccines")
	public ResponseEntity<Vaccine> addVaccineToSystem(@RequestBody Vaccine vaccine){
		
	Vaccine savedvaccine =	vService.addVaccine(vaccine);
		
	return new ResponseEntity<Vaccine>(savedvaccine,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/vaccines/{vaccinename}")
	public ResponseEntity<Vaccine> getVaccineByNameHandler(@PathVariable("vaccinename") String vaccinename){
		
	Vaccine savedvaccine =	vService.getVaccinByName(vaccinename);
		
	return new ResponseEntity<Vaccine>(savedvaccine,HttpStatus.OK);
		
	}
	
	@GetMapping("/vaccinesById/{vaccinid}")
	public ResponseEntity<Vaccine> getVaccineByIDHandler(@PathVariable("vaccinid") Integer vaccinid){
		
	Vaccine savedvaccine =	vService.getVaccineById(vaccinid);
		
	return new ResponseEntity<Vaccine>(savedvaccine,HttpStatus.OK);
		
	}
	
	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> getAllVaccineHandler(){
		
	List<Vaccine> list =	vService.getAllVaccine();
		
	return new ResponseEntity<List<Vaccine>>(list,HttpStatus.OK);
		
	}
	
}
