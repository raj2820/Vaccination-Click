package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment ,@PathVariable("id") Integer id){
		
		Appointment addedappontenment = appointmentService.addAppointment(appointment, id);
		
		return new ResponseEntity<Appointment>(addedappontenment,HttpStatus.CREATED);
		
	}
	
}
