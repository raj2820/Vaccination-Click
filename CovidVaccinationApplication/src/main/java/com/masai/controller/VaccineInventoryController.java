package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.VaccineInventory;
import com.masai.service.VaccinationInventoryService;

// import com.vaccinationclick.model.Vaccine;

@RestController
public class VaccineInventoryController {
	@Autowired
	private VaccinationInventoryService vaccineInventoryServise;
	
//	@Autowired
//	private VaccineService vaccineService;
	
	@GetMapping("/inventories")
	public ResponseEntity<List<VaccineInventory>> getAllVaccineHandler(){
		
		List<VaccineInventory> vaccines = vaccineInventoryServise.allVaccineInventory();
		
		return new ResponseEntity<List<VaccineInventory>>(vaccines,HttpStatus.OK);
	}
	
	@GetMapping("/inventories/{centerId}")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByCenterHandler(@PathVariable("centerId") Integer centerId){
		
		VaccineInventory vaccineInventory =  vaccineInventoryServise.getVaccineInventoryByCenter(centerId);
		
		return new ResponseEntity<VaccineInventory>(vaccineInventory,HttpStatus.FOUND);
	}
	
	@PostMapping("/addvaccine/{id}")
	public ResponseEntity<VaccineInventory> addVaccineHandler(@RequestBody VaccineInventory vaccineInventory ,@PathVariable("id") Integer id){
		
		VaccineInventory Inventory =  vaccineInventoryServise.addVaccine(vaccineInventory, id);
		
		
		return new ResponseEntity<VaccineInventory>(Inventory,HttpStatus.OK);
	}
	
	@PostMapping("/updateinventories")
	public ResponseEntity<VaccineInventory> updateVaccineInventoryHandler(@RequestBody VaccineInventory vaccineInventory){
		
		VaccineInventory Inventory =  vaccineInventoryServise.updateVaccineInventory(vaccineInventory);
		
		
		return new ResponseEntity<VaccineInventory>(Inventory,HttpStatus.ACCEPTED);
	}
	
	
	
	@PostMapping("/deleteinventories")
	public ResponseEntity<Boolean> deleteVaccineInventoryHandler(@RequestBody VaccineInventory vaccineInventory){
		
		Boolean Inventory =  vaccineInventoryServise.deleteVaccineInventory(vaccineInventory);
		
		
		return new ResponseEntity<Boolean>(Inventory,HttpStatus.OK);
	}
	
	
	//manually putting date possible??**********************************************
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByDateHandler(LocalDate date){
		
		List<VaccineInventory> allInventory =  vaccineInventoryServise.getVaccineInventoryByDate(date);
		
		return new ResponseEntity<List<VaccineInventory>>(allInventory,HttpStatus.OK);
		
	}
	
//	@PostMapping("/getinventories")
//	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryHandler(@RequestBody Vaccine vaccine){
//		
//		List<VaccineInventory> inventoryList =  vaccineInventoryServise.getVaccineInventory(vaccine);
//		
//		return new ResponseEntity<List<VaccineInventory>>(inventoryList,HttpStatus.OK);
//		
//	}
	
	
	
	
	
	
	
	

}
