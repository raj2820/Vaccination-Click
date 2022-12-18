package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaccineId;
	@NotNull(message="Vaccine name should not be empty")
	private String vaccineName;
	@NotNull(message="Description  should not be empty")
	private String description;

	@NotNull (message="Vaccine count  should not be null")
	@Embedded
	private VaccineCount vaccineCount;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy="vaccine",fetch = FetchType.EAGER)
	private VaccineInventory vaccineInventory;

public Integer getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VaccineCount getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(VaccineCount vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

	public VaccineInventory getVaccineInventory() {
		return vaccineInventory;
	}

	public void setVaccineInventory(VaccineInventory vaccineInventory) {
		this.vaccineInventory = vaccineInventory;
	}
	
	
	
	
}
