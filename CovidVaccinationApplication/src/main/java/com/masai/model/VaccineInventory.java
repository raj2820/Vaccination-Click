package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;




public class VaccineInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer InventoryId;
	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate localDate;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;
	
	
	@OneToOne (cascade = CascadeType.ALL)
	private VaccinationCenter vaccinationCenter;

	public Integer getInventoryId() {
		return InventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		InventoryId = inventoryId;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}
	
	

}
