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

import com.masai.model.Appointment;
import com.masai.service.AppointmentService;

@RestController
public class AppoinmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping("/appointments/{id}")
	public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment ,@PathVariable("id") Integer id){
		
		Appointment addedappontenment = appointmentService.addAppointment(appointment, id);
		
		return new ResponseEntity<Appointment>(addedappontenment,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/appointmentList")
	public ResponseEntity<List<Appointment>>  getAllAppointmentsHandler(){
		
		List<Appointment> appointments = appointmentService.getAllAppointments();
		
		return new ResponseEntity<List<Appointment>>(appointments,HttpStatus.OK);
		
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
	
	
}
