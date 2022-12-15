package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AppointmentException;
import com.masai.model.Appointment;
import com.masai.repository.AppointmentDao;




@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public List<Appointment> getAllAppointments() {
		
		List<Appointment> appointments = appointmentDao.findAll();
		return appointments;
	}

	@Override
	public Appointment getAppointment(Integer bookingId) {
		
		Appointment appointment = appointmentDao.findById(bookingId).orElseThrow(()->new IllegalArgumentException("Booking Id "+bookingId+" is Invalid or not availble."));
		
		return appointment;
	}

	@Override
	public Appointment addAppointment(Appointment appointment) {
		 return appointmentDao.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		Optional<Appointment> optionalAppointment = appointmentDao.findById(appointment.getBookingId());
		
		if(optionalAppointment.isEmpty()) {
			throw new AppointmentException("Invalid Appointment Id or appointment Id is not avaialabel");
		}
		
		Appointment updatedAppointment = optionalAppointment.get();
		appointmentDao.save(updatedAppointment);
		return updatedAppointment;
	}

	@Override
	public boolean deleteAppointment(Appointment appointment) {
		Optional<Appointment> optionalAppointment = appointmentDao.findById(appointment.getBookingId());
		
		if(optionalAppointment.isEmpty()) {
			throw new AppointmentException("Invalid Appointment Id or appointment Id is not avaialabel");
		}
		
		Appointment deleteAppointment = optionalAppointment.get();
		appointmentDao.delete(deleteAppointment);
		return true;
	}
	
	

}
