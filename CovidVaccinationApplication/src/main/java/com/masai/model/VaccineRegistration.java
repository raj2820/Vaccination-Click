package com.masai.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.OneToOne;

@Entity
public class VaccineRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer registrationNo;
	private Long mobileno;
	private LocalDate dateofregistration;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	
	
	public VaccineRegistration() {
		// TODO Auto-generated constructor stub
	}
	
	public VaccineRegistration(long mobileno, LocalDate dateofregistration) {
		super();
		this.mobileno = mobileno;
		this.dateofregistration = dateofregistration;
	}

	public Integer getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(Integer registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public LocalDate getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(LocalDate dateofregistration) {
		this.dateofregistration = dateofregistration;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "VaccineRegistration [registrationNo=" + registrationNo + ", mobileno=" + mobileno
				+ ", dateofregistration=" + dateofregistration + ", member=" + member + "]";
	}

}
