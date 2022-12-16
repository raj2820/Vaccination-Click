package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.VaccinationCenterException;
import com.masai.model.VaccinationCenter;
import com.masai.service.VaccinationCenterService;

@RestController
public class VaccinationCenterController {
	
	
	@Autowired
	private VaccinationCenterService vcs;
	
	
	@GetMapping("/vaccinationCenter/{code}")
	public ResponseEntity<VaccinationCenter> getVaccineCenterHandler(@PathVariable("code") Integer code) throws VaccinationCenterException{
		
		VaccinationCenter vc=vcs.getVaccineCenter(code);
		
		return new ResponseEntity<VaccinationCenter>(vc,HttpStatus.OK);
		
	}
	
	@GetMapping("/vaccinationCenterbystate/{state}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByStateHandler(@PathVariable("state") String state) throws VaccinationCenterException{
		
		List<VaccinationCenter> vc=vcs.getVaccineCenterByState(state);
		
		return new ResponseEntity<List<VaccinationCenter>>(vc,HttpStatus.OK);
	}
	
	@GetMapping("/vaccinationCenterbycity/{city}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByCityHandler(@PathVariable("city") String city) throws VaccinationCenterException{
		
		List<VaccinationCenter> vc=vcs.getVaccineCenterByCity(city);
		
		return new ResponseEntity<List<VaccinationCenter>>(vc,HttpStatus.OK);
	}
	
	@GetMapping("/vaccinationCenter")
	public ResponseEntity<List<VaccinationCenter>> getAllVaccinationCenterHandler() throws VaccinationCenterException{
		
		List<VaccinationCenter> vc=vcs.getAllVaccineCenter();
		
		return new ResponseEntity<List<VaccinationCenter>>(vc,HttpStatus.OK);
	}
	
	
	@PostMapping("/vaccinationCenter")
	public ResponseEntity<VaccinationCenter>  addVaccinationCenterHandler(@RequestBody VaccinationCenter vacc){
		
		VaccinationCenter vc=vcs.addVaccineCenter(vacc);
		
		return new ResponseEntity<VaccinationCenter>(vc,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/vaccinationCenter")
	public ResponseEntity<VaccinationCenter> updateVaccinationCenterHandler(@RequestBody VaccinationCenter vacc) throws VaccinationCenterException{
		
		VaccinationCenter updateVc =vcs.updateVaccineCenter(vacc);
		
		return new ResponseEntity<VaccinationCenter>(updateVc,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/vaccinationCenter/{code}")
	public ResponseEntity<Boolean> deleteVaccinationCenterHandler(@PathVariable("code") Integer code) throws VaccinationCenterException {
		
		Boolean deleteVc=vcs.deleteVaccineCenter(code);
		
		return new ResponseEntity<Boolean>(deleteVc,HttpStatus.OK);
		
		
	}

	
	

}
