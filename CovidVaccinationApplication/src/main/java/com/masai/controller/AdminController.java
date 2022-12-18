package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.exception.LoginException;
import com.masai.exception.VaccinationCenterException;
import com.masai.exception.VaccineInventoryException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.Admin;
import com.masai.model.Appointment;
import com.masai.model.Member;
import com.masai.model.VaccinationCenter;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;
import com.masai.service.AdminService;
import com.masai.service.AppointmentService;
import com.masai.service.VaccinationCenterService;
import com.masai.service.VaccinationInventoryService;
import com.masai.service.VaccineRegistrationService;
import com.masai.service.VaccineService;

@RestController
public class AdminController {
	
	 @Autowired
	 private AdminService adminService;
	 
	 @PostMapping("/admins")
	   public ResponseEntity<Admin> saveAdminHandlerAdmin(@Valid @RequestBody Admin admin) throws AdminException {

	        Admin savedAdmin= adminService.createAdmin(admin);


	        return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CREATED);
	    }
	 @PutMapping("/admins")
	    public  ResponseEntity<Admin> updateUserHandler(@Valid @RequestBody Admin admin,@RequestParam(required = false ) String key ) throws AdminException {


	        Admin updatedAdmin= adminService.updateAdmin(admin,key);

	        return new ResponseEntity<Admin>(updatedAdmin,HttpStatus.OK);

	    }
	 
	 
	 //=============================appointment related service
	 @Autowired
	 private AppointmentService appointmentService;
		@GetMapping("/appointmentList")
		public ResponseEntity<List<Appointment>>  getAllAppointmentsHandlerAdmin(){
			
			List<Appointment> appointments = appointmentService.getAllAppointments();
			
			return new ResponseEntity<List<Appointment>>(appointments,HttpStatus.OK);
			
		}
		
//==============================vaccination center service
		
		@Autowired
		private VaccinationCenterService vcs;
		@GetMapping("/vaccinationCenterAdmin/{code}")
		public ResponseEntity<VaccinationCenter> getVaccineCenterHandlerAdmin( @PathVariable("code") Integer code) throws VaccinationCenterException{
			
			VaccinationCenter vc=vcs.getVaccineCenter(code);
			
			return new ResponseEntity<VaccinationCenter>(vc,HttpStatus.OK);
			
		}
		
		@GetMapping("/vaccinationCenterbystateAdmin/{state}")
		public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByStateHandlerAdmin(@PathVariable("state") String state) throws VaccinationCenterException{
			
			List<VaccinationCenter> vc=vcs.getVaccineCenterByState(state);
			
			return new ResponseEntity<List<VaccinationCenter>>(vc,HttpStatus.OK);
		}
		
		@GetMapping("/vaccinationCenterbycityAdmin/{city}")
		public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByCityHandlerAdmin(@PathVariable("city") String city) throws VaccinationCenterException{
			
			List<VaccinationCenter> vc=vcs.getVaccineCenterByCity(city);
			
			return new ResponseEntity<List<VaccinationCenter>>(vc,HttpStatus.OK);
		}
		
		@GetMapping("/vaccinationCenterAdmin")
		public ResponseEntity<List<VaccinationCenter>> getAllVaccinationCenterHandlerAdmin() throws VaccinationCenterException{
			
			List<VaccinationCenter> vc=vcs.getAllVaccineCenter();
			
			return new ResponseEntity<List<VaccinationCenter>>(vc,HttpStatus.OK);
		}
		
		@PutMapping("/vaccinationCenterAdmin")
		public ResponseEntity<VaccinationCenter> updateVaccinationCenterHandlerAdmin(@Valid @RequestBody VaccinationCenter vacc ,@RequestParam("key")String key) throws VaccinationCenterException,LoginException{
			
			VaccinationCenter updateVc =vcs.updateVaccineCenter(vacc,key);
			
			return new ResponseEntity<VaccinationCenter>(updateVc,HttpStatus.ACCEPTED);
			
			
		}
		
		@DeleteMapping("/vaccinationCenterAdmin/{code}")
		public ResponseEntity<Boolean> deleteVaccinationCenterHandlerAdmin(@PathVariable("code") Integer code ,@RequestParam("key")String key) throws VaccinationCenterException,LoginException{
			
			Boolean deleteVc=vcs.deleteVaccineCenter(code,key);
			
			return new ResponseEntity<Boolean>(deleteVc,HttpStatus.OK);
			
			
		}

		@Autowired
		private VaccinationCenterService vaccinationCenterService;
		
		@PostMapping("/vcregisterAdmin")
		public ResponseEntity<VaccinationCenter> addVaccinationCenterAdmin(@Valid @RequestBody VaccinationCenter vaccinationCenter,@RequestParam("key")String key) throws VaccinationCenterException,LoginException{
			
			VaccinationCenter vc =	vaccinationCenterService.addVaccineCenter(vaccinationCenter,key);
			
			return new ResponseEntity<VaccinationCenter>(vc,HttpStatus.CREATED);
		}
		
		
		//=======================Vaccination registration related services
		@Autowired
		private VaccineRegistrationService vaccineRegistrationService;
		
		@GetMapping("/allregisteration")
		public ResponseEntity<List<Member>> getAllRegistrationsAdmin() throws VaccineRegistrationException{
			List<Member> members=vaccineRegistrationService.getAllMemberList();
			
		
			
			return new ResponseEntity<List<Member>>(members,HttpStatus.OK);
		}
		
		//============================Vaccine related services
		
		
		@Autowired
		private VaccineService vService;
		
		
		@PostMapping("/vaccines")
		public ResponseEntity<Vaccine> addVaccineToSystemHandlerAdmin(@Valid @RequestBody Vaccine vaccine ,@RequestParam("key")String key)throws LoginException{
			
		Vaccine savedvaccine =	vService.addVaccine(vaccine,key);
			
		return new ResponseEntity<Vaccine>(savedvaccine,HttpStatus.CREATED);
			
		}
		
		@PutMapping("/vaccines")
		public ResponseEntity<Vaccine> updateVaccineGandlerAdmin(@RequestBody Vaccine vaccine ,@RequestParam("key") String key)throws LoginException{
			
		Vaccine savedvaccine =	vService.updateVaccine(vaccine,key);
			
		return new ResponseEntity<Vaccine>(savedvaccine,HttpStatus.CREATED);
			
		}
		
		
		@GetMapping("/vaccines/{vaccinename}")
		public ResponseEntity<Vaccine> getVaccineByNameHandlerAdmin(@PathVariable("vaccinename") String vaccinename){
			
		Vaccine savedvaccine =	vService.getVaccinByName(vaccinename);
			
		return new ResponseEntity<Vaccine>(savedvaccine,HttpStatus.OK);
			
		}
		
		@GetMapping("/vaccinesById/{vaccinid}")
		public ResponseEntity<Vaccine> getVaccineByIDHandlerAdmin(@PathVariable("vaccinid") Integer vaccinid){
			
		Vaccine savedvaccine =	vService.getVaccineById(vaccinid);
			
		return new ResponseEntity<Vaccine>(savedvaccine,HttpStatus.OK);
			
		}
		
		@GetMapping("/vaccines")
		public ResponseEntity<List<Vaccine>> getAllVaccineHandlerAdmin(){
			
		List<Vaccine> list =	vService.getAllVaccine();
			
		return new ResponseEntity<List<Vaccine>>(list,HttpStatus.OK);
			
		}
//=============================================vaccine inventory
		
		@Autowired
		private VaccinationInventoryService vaccineInventoryServise;
		

		
		@GetMapping("/inventories")
		public ResponseEntity<List<VaccineInventory>> getAllVaccineInvetoryHandlerAdmin(){
			
			List<VaccineInventory> vaccines = vaccineInventoryServise.allVaccineInventory();
			
			return new ResponseEntity<List<VaccineInventory>>(vaccines,HttpStatus.OK);
		}
		
		@GetMapping("/inventories/{centerId}")
		public ResponseEntity<VaccineInventory> getVaccineInventoryByCenterHandlerAdmin(@PathVariable("centerId") Integer centerId){
			
			VaccineInventory vaccineInventory =  vaccineInventoryServise.getVaccineInventoryByCenter(centerId);
			
			return new ResponseEntity<VaccineInventory>(vaccineInventory,HttpStatus.FOUND);
		}
		
		@PostMapping("/addvaccine/{id}/{vcid}")
		public ResponseEntity<VaccineInventory> addVaccineHandlerAdmin(@RequestBody VaccineInventory vaccineInventory,@RequestParam("key")String key ,@PathVariable("id") Integer id ,@PathVariable("vcid") Integer vcid)throws LoginException{
			
			VaccineInventory Inventory =  vaccineInventoryServise.addVaccine(vaccineInventory, id,vcid,key);
			
			
			return new ResponseEntity<VaccineInventory>(Inventory,HttpStatus.OK);
		}
		
		@PostMapping("/updateinventories")
		public ResponseEntity<VaccineInventory> updateVaccineInventoryHandlerAdmin(@RequestBody VaccineInventory vaccineInventory,@RequestParam("key") String key)throws LoginException{
			
			VaccineInventory Inventory =  vaccineInventoryServise.updateVaccineInventory(vaccineInventory,key);
			
			
			return new ResponseEntity<VaccineInventory>(Inventory,HttpStatus.ACCEPTED);
		}
		
		
		
		@DeleteMapping("/deleteinventories")
		public ResponseEntity<Boolean> deleteVaccineInventoryHandlerAdmin(@RequestBody VaccineInventory vaccineInventory,@RequestParam("key") String key)throws LoginException{
			
			Boolean Inventory =  vaccineInventoryServise.deleteVaccineInventory(vaccineInventory,key);
			
			
			return new ResponseEntity<Boolean>(Inventory,HttpStatus.OK);
		}
		
		

		
		
		@GetMapping("/getallinventorybydate/{date}")
		public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByDateHandlerAdmin(@PathVariable("date") LocalDate date){
			
			List<VaccineInventory> allInventory =  vaccineInventoryServise.getVaccineInventoryByDate(date);
			
			return new ResponseEntity<List<VaccineInventory>>(allInventory,HttpStatus.OK);
			
		}

		
		
		@GetMapping("/getinventories")
		public ResponseEntity<List<VaccineInventory>> getVaccineInventoryHandlerAdmin(@RequestBody Vaccine vaccine)throws VaccineInventoryException{
			
			List<VaccineInventory> inventoryList =  vaccineInventoryServise.getVaccineInventory(vaccine);
			
			return new ResponseEntity<List<VaccineInventory>>(inventoryList,HttpStatus.OK);
			
		}
		
		
}
