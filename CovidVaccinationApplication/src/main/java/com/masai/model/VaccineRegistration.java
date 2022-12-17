package com.masai.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class VaccineRegistration {
	
	@Id
	private Long mobileno;
	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateofregistration;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="vaccineRegistration")
	private List<Member> memberList;

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
//
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
