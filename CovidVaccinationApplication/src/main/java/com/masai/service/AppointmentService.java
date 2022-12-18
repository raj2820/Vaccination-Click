package com.masai.service;

import java.util.List;

import com.masai.exception.AppointmentException;
import com.masai.exception.LoginException;
import com.masai.model.Appointment;

public interface AppointmentService {
	
public List<Appointment> getAllAppointments();
	
	public Appointment getAppointment(Integer bookingId) throws AppointmentException;
	
	public Appointment addAppointment(Appointment appointment,Integer id ,String key) throws AppointmentException ,LoginException;
	
	//public List<VaccinationCenter> addAppointment() throws AppointmentException;
	
	public Appointment updateAppointment(Appointment appointmentString ,String key) throws AppointmentException ,LoginException;
	
	public boolean deleteAppointment(Appointment appointment ,String key) throws AppointmentException ,LoginException;
}
