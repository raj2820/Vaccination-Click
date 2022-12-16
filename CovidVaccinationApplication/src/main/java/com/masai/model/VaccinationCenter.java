package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccinationCenter {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaccineCode;
	private String centerName;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private VaccineInventory vaccineInventory;
	
	
	public VaccinationCenter() {
	
	}

	public VaccinationCenter(Integer vaccineCode, String centerName, String address, String city, String state,
			String pincode) {
		super();
		this.vaccineCode = vaccineCode;
		this.centerName = centerName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
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

	@Override
	public String toString() {
		return "VaccinationCenter [vaccineCode=" + vaccineCode + ", centerName=" + centerName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	

}
