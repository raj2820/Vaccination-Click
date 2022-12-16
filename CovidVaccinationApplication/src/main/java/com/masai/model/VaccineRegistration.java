package com.masai.model;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class VaccineRegistration {
	
	@Id
	private Long mobileno;
	private LocalDate dateofregistration;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	List<Member> memberList;

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

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public VaccineRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VaccineRegistration(Long mobileno, LocalDate dateofregistration, List<Member> memberList) {
		super();
		this.mobileno = mobileno;
		this.dateofregistration = dateofregistration;
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "VaccineRegistration [mobileno=" + mobileno + ", dateofregistration=" + dateofregistration
				+ ", memberList=" + memberList + "]";
	}
	
	
	

	
	
	

}
