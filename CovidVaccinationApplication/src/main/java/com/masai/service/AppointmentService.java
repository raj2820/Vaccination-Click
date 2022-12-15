package com.masai.service;

import java.util.List;

import com.masai.exception.AppointmentException;
import com.masai.model.Appointment;

public interface AppointmentService {
	
	public List<Appointment> getAllAppointments();
	
	public Appointment getAppointment(Integer bookingId) throws AppointmentException;
	
	public Appointment addAppointment(Appointment appointment) throws AppointmentException;
	
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException;
	
	public boolean deleteAppointment(Appointment appointment) throws AppointmentException;
}
