package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineCode;
	private String centerName;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private LocalDateTime date;
	
	
	public VaccinationCenter() {
	}


	public VaccinationCenter(Integer vaccineCode, String centerName, String address, String city, String state,
			String pincode, LocalDateTime date) {
		super();
		this.vaccineCode = vaccineCode;
		this.centerName = centerName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.date = date;
	}


	public Integer getVaccineCode() {
		return vaccineCode;
	}


	public void setVaccineCode(Integer vaccineCode) {
		this.vaccineCode = vaccineCode;
	}


	public String getCenterName() {
		return centerName;
	}


	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "VaccinationCenter [vaccineCode=" + vaccineCode + ", centerName=" + centerName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", date=" + date + "]";
	}
	
	

}
