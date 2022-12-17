package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AppointmentException;
import com.masai.model.Appointment;
import com.masai.model.Member;
import com.masai.model.VaccinationCenter;
import com.masai.model.VaccineRegistration;
import com.masai.repository.AppointmentDao;
import com.masai.repository.MemberDao;
import com.masai.repository.VaccinationCenterDao;
import com.masai.repository.VaccineRegistrationDao;




@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private VaccineRegistrationDao vaccineRegistrationDao;
	
	@Autowired
	private VaccinationCenterDao vaccinationCenterDao;

	
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
	public Appointment addAppointment(Appointment appointment,Integer id) {
		
		
		VaccinationCenter center=null;
	//List<Member> members =	memberDao.getAllMemberByPhone(appointment.getMobileNo());
		Optional<VaccineRegistration> vc =vaccineRegistrationDao.findById(appointment.getMobileNo());
	
	Member member =	memberDao.findById(id).get();
		appointment.setMember(member);
		
		
		
		
		
		
		List<VaccinationCenter> centerList =	vaccinationCenterDao.findAll();
		
		for (VaccinationCenter vaccinationCenter : centerList) {
			
			if(member.getIdcard().getCity().equals(vaccinationCenter.getCity())) {
				
				center=vaccinationCenter;
				
			
				break;
			
			}
			
		}
		
		
		
	appointment.setVaccinationCenter(center);
	
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
