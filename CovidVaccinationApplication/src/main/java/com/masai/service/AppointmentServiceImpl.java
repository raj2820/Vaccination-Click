package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AppointmentException;
import com.masai.exception.LoginException;
import com.masai.model.Appointment;
import com.masai.model.CurrentUserSession;
import com.masai.model.Member;
import com.masai.model.VaccinationCenter;
import com.masai.model.VaccineRegistration;
import com.masai.repository.AppointmentDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.MemberDao;
import com.masai.repository.VaccinationCenterDao;
import com.masai.repository.VaccineRegistrationDao;
import com.masai.model.Slots;



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
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Override
	public List<Appointment> getAllAppointments() throws AppointmentException{
		
		
		
		List<Appointment> appointments = appointmentDao.findAll();
		
		if(appointments.isEmpty()) {
			throw new AppointmentException("No Appointments Available");
		}
		return appointments;
	}

	@Override
	public Appointment getAppointment(Integer bookingId) throws AppointmentException{
		
		Appointment appointment = appointmentDao.findById(bookingId).orElseThrow(()->new AppointmentException("Booking Id "+bookingId+" is Invalid or not availble."));
		
		return appointment;
	}

	@Override
	public Appointment addAppointment(Appointment appointment,Integer id,String key)throws AppointmentException,LoginException {
		CurrentUserSession userCurrent=currentUserSessionDao.findByUuid(key);
		if(userCurrent.equals(null)) {
			
			throw new LoginException("User not logged in");
		}
		
		
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
		
			Slots newslots =  Slots.getRandomSlot();
			if(newslots.isStatus()==false) {
				newslots.setStatus(true);
				appointment.setSlot(newslots);
			}else {
				while(newslots.isStatus()==false) {
					if(newslots.isStatus()==false) {
						
						newslots.setStatus(true);
						appointment.setSlot(newslots);
						break;
						
					}
					newslots =  Slots.getRandomSlot();
				}
			}
	
			appointment.setVaccinationCenter(center);
		
			
			return appointmentDao.save(appointment);	
	}

	@Override
	public Appointment updateAppointment(Appointment appointment,String key)throws AppointmentException,LoginException {
		
		
		CurrentUserSession userCurrent=currentUserSessionDao.findByUuid(key);
		if(userCurrent.equals(null)) {
			
			throw new LoginException("User not logged in");
		}
		
		Optional<Appointment> optionalAppointment = appointmentDao.findById(appointment.getBookingId());
		
		if(optionalAppointment.isEmpty()) {
			throw new AppointmentException("Invalid Appointment Id or appointment Id is not avaialabel");
		}
		
		Appointment updatedAppointment = optionalAppointment.get();
		appointmentDao.save(updatedAppointment);
		return updatedAppointment;
	}

	@Override
	public boolean deleteAppointment(Appointment appointment,String key)throws AppointmentException,LoginException {
		
		CurrentUserSession userCurrent=currentUserSessionDao.findByUuid(key);
		if(userCurrent.equals(null)) {
			
			throw new LoginException("User not logged in");
		}
		
		
		
		Optional<Appointment> optionalAppointment = appointmentDao.findById(appointment.getBookingId());
		
		if(optionalAppointment.isEmpty()) {
			throw new AppointmentException("Invalid Appointment Id or appointment Id is not avaialabel");
		}
		
		Slots slotStatus = appointment.getSlot();
		slotStatus.setStatus(false);
		
		
		Appointment deleteAppointment = optionalAppointment.get();
		appointmentDao.delete(deleteAppointment);
		return true;
	}
	

}
