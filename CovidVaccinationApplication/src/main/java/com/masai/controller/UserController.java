package com.masai.controller;

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

import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.exception.VaccinationCenterException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.AadharCard;
import com.masai.model.Appointment;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.PanCard;
import com.masai.model.User;
import com.masai.model.VaccinationCenter;
import com.masai.model.VaccineRegistration;
import com.masai.service.AppointmentService;
import com.masai.service.IdCardService;
import com.masai.service.MemberService;
import com.masai.service.UserService;
import com.masai.service.VaccinationCenterService;
import com.masai.service.VaccineRegistrationService;


@RestController
public class UserController {
	
	 @Autowired
	    private UserService userService;

	    @PostMapping("/users")
	    public ResponseEntity<User> saveUserHandler(@Valid @RequestBody User user) throws UserException {

	        User savedUser= userService.createUser(user);


	        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	    }

	    @PutMapping("/users")
	    public  ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user,@RequestParam(required = false ) String key ) throws UserException {


	        User updatedUser= userService.updateUser(user, key);

	        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);

	    }
	    
	   //==============================================================
	    
	    
		//Member related services===========================
		@Autowired
		private MemberService ms;
		
		@PostMapping("/members")
		public ResponseEntity<Member> registerMember(@Valid @RequestBody Member member ,@RequestParam("phone") Long phone , @RequestParam("key") String key) throws LoginException{
			
			Member m =	ms.addMember(member,phone,key);
				
			return new ResponseEntity<Member>(m,HttpStatus.CREATED);
		
		}
		
		@GetMapping("/memberById/{id}")
		public ResponseEntity<Member> getMemberById(@PathVariable("id") Integer id){
			
			Member m=ms.getMemberById(id);
			
			return new ResponseEntity<Member>(m,HttpStatus.OK);
			
		}

		@GetMapping("/memberByAdhar/{adharNo}")
		public ResponseEntity<Member> getMemberByAdhar(@PathVariable("adharNo") Long adhar){
			
			Member m=ms.getMemberByAdharNo(adhar);
			
			return new ResponseEntity<Member>(m,HttpStatus.OK);
			
		}
		@GetMapping("/memberByPan/{panNo}")
		public ResponseEntity<Member> getMemberByPan(@PathVariable("panNo") String pan){
			
			Member m=ms.getMemberByPanNo(pan);
			
			return new ResponseEntity<Member>(m,HttpStatus.OK);
			
		}
		@GetMapping("/allmembers")
		public ResponseEntity<List<Member>> getAllMember(){
			
			List<Member> m=ms.getAllMembers();
			
			return new ResponseEntity<List<Member>>(m,HttpStatus.OK);
			
		}
		
		//===============================id_card related services
		
		@Autowired
		private IdCardService idCardService;
		
		@GetMapping("/getpancard")
		public ResponseEntity<PanCard> getPanCardByNumberHandler(@Valid @RequestParam String panNo){
			
			PanCard idCard = idCardService.getPanCardByNumber(panNo);
			
			return new ResponseEntity<PanCard>(idCard,HttpStatus.OK);
		}
		
		@GetMapping("/getaddhar")
	    public ResponseEntity<AadharCard> getAadharCardNumberHandler(@Valid @RequestParam Long aadharNo) {
	    	
	        AadharCard idCard = idCardService.getAadharCardNumber(aadharNo);
			
			return new ResponseEntity<AadharCard>(idCard,HttpStatus.OK);
			
	    }
		
		
		@PostMapping("/addcard/{id}")
		public ResponseEntity<IdCard> addIdCardHandler(@Valid @RequestBody IdCard idCard ,@PathVariable("id") Integer id ,@RequestParam("key") String key) throws LoginException{
			IdCard newCard =  idCardService.addIdCard(idCard, id,key);
			
			
			return new ResponseEntity<IdCard>(newCard,HttpStatus.CREATED);
		}
	    
		
	    //=======================appointement related services
		
		@Autowired
		private AppointmentService appointmentService;
		
		
		@PostMapping("/appointments/{id}")
		public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment ,@PathVariable("id") Integer id){
			
			Appointment addedappontenment = appointmentService.addAppointment(appointment, id);
			
			return new ResponseEntity<Appointment>(addedappontenment,HttpStatus.CREATED);
			
		}
	    
	    
		@GetMapping("/getappointment/{id}")
		public ResponseEntity<Appointment> getAppointmentHandler(@Valid @PathVariable("id") Integer id){
			
			Appointment appointment = appointmentService.getAppointment(id);
			
			return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
		}
		
		
		@PutMapping("/updateappointment")
		public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment appointment){
			
			Appointment updateAppointment = appointmentService.updateAppointment(appointment);
			
			return new ResponseEntity<Appointment>(updateAppointment,HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteappointment")
		public ResponseEntity<Boolean> deleteAppointment(@Valid @RequestBody Appointment appointment){
			Boolean deleteAppointment = appointmentService.deleteAppointment(appointment);
			
			return new ResponseEntity<Boolean>(deleteAppointment,HttpStatus.OK);
			
		}
		
		//=============================================
		
		@Autowired
		private VaccinationCenterService vcs;
		
		@GetMapping("/vaccinationCenter/{code}")
		public ResponseEntity<VaccinationCenter> getVaccineCenterHandler( @PathVariable("code") Integer code) throws VaccinationCenterException{
			
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
	    
	    //==============vaccination registration
		@Autowired
		private VaccineRegistrationService vaccineRegistrationService;
		
		@PostMapping("/register")
		public ResponseEntity<VaccineRegistration> addvaccineRegistrationHandler(@RequestBody VaccineRegistration vaccineRegistration, @RequestParam("key") String key) throws VaccineRegistrationException ,LoginException{
			
			
			VaccineRegistration registered = vaccineRegistrationService.addVaccineRegistration(vaccineRegistration ,key);
			
			return new ResponseEntity<VaccineRegistration>(registered,HttpStatus.CREATED);
		}
		@GetMapping("/getregistrationByMobile/{ph}")
		public ResponseEntity<VaccineRegistration> getVaccineRegistration(@PathVariable("ph") long moblieno)throws VaccineRegistrationException{
			
			VaccineRegistration vr=vaccineRegistrationService.getVaccineRegistration(moblieno);
			
			
			return new ResponseEntity<VaccineRegistration>(vr,HttpStatus.OK);
			
			
		}
		
		@PutMapping("/updateRegistration")
		public  ResponseEntity<VaccineRegistration> updateVaccineRegistration(@RequestBody VaccineRegistration reg)throws VaccineRegistrationException{
			
			
			VaccineRegistration upvr=vaccineRegistrationService.updateVaccineRegistration(reg);
			
			
			return new ResponseEntity<VaccineRegistration>(upvr,HttpStatus.OK);
			
			
		}
		@DeleteMapping("/vaccineRegistration/{MobileNo}")
		public ResponseEntity<Boolean> deleteVaccineRegistrationHandler(@PathVariable("MobileNo") Long mobileNo ) throws VaccineRegistrationException{
			Boolean deleteVaccineRegistration = vaccineRegistrationService.deleteVaccineRegistration(mobileNo);
			
			return new ResponseEntity<Boolean>(deleteVaccineRegistration,HttpStatus.OK);
		}
	    

}
