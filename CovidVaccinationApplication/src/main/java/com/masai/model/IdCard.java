package com.masai.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class IdCard {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String name;
	private LocalDate dob;
	private String gender;
	private String city;
	private String state;
	private String pincode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Member member;
	
	@Embedded
	private AadharCard adharcard;

	@Embedded
	private PanCard panCard;
	
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}

	
	


	public IdCard(Member member) {
		super();
		this.member = member;
	}


	public IdCard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IdCard(Integer id, String name, LocalDate dob, String gender, String city, String state, String pincode,
			Member member, AadharCard adharcard, PanCard panCard) {
		super();
		Id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.member = member;
		this.adharcard = adharcard;
		this.panCard = panCard;
	}


	public AadharCard getAdharcard() {
		return adharcard;
	}


	public void setAdharcard(AadharCard adharcard) {
		this.adharcard = adharcard;
	}


	public PanCard getPanCard() {
		return panCard;
	}


	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	
	

	
}
