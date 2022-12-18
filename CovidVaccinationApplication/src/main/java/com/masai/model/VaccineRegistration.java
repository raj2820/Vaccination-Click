package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class VaccineRegistration {
	
	@Id
	private Long mobileno;
	//@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDateTime dateofregistration=LocalDateTime.now();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="vaccineRegistration")
	private List<Member> memberList;

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}



	public LocalDateTime getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(LocalDateTime dateofregistration) {
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



	@Override
	public String toString() {
		return "VaccineRegistration [mobileno=" + mobileno + ", dateofregistration=" + dateofregistration
				+ ", memberList=" + memberList + "]";
	}
	
	
	
	

}
