package com.masai.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity

public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	private boolean dose1;
	private boolean dose2;
	private LocalDateTime dose1Date;
	private LocalDateTime dose2Date;
	


	@OneToOne(cascade = CascadeType.ALL,mappedBy ="member",fetch = FetchType.EAGER)
	private IdCard idcard;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="member")
	private List<Appointment> appointments;

	public Integer getMemberId() {
		return memberId;
	}



	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}



	public boolean isDose1() {
		return dose1;
	}



	public void setDose1(boolean dose1) {
		this.dose1 = dose1;
	}



	public boolean isDose2() {
		return dose2;
	}



	public void setDose2(boolean dose2) {
		this.dose2 = dose2;
	}



	public LocalDateTime getDose1Date() {
		return dose1Date;
	}



	public void setDose1Date(LocalDateTime dose1Date) {
		this.dose1Date = dose1Date;
	}



	public LocalDateTime getDose2Date() {
		return dose2Date;
	}



	public void setDose2Date(LocalDateTime dose2Date) {
		this.dose2Date = dose2Date;
	}



	public IdCard getIdcard() {
		return idcard;
	}



	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
	}



	public VaccineRegistration getVaccineRegistration() {
		return vaccineRegistration;
	}



	public void setVaccineRegistration(VaccineRegistration vaccineRegistration) {
		this.vaccineRegistration = vaccineRegistration;
	}



	public List<Appointment> getAppointments() {
		return appointments;
	}



	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	
}
