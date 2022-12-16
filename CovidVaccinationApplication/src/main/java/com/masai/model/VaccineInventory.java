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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
public class VaccineInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer InventoryId;
	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate localDate;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;

	public VaccineInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VaccineInventory(Integer inventoryId, LocalDate localDate, Vaccine vaccine) {
		super();
		InventoryId = inventoryId;
		this.localDate = localDate;
		this.vaccine = vaccine;
	}

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

	@Override
	public String toString() {
		return "VaccineInventory [InventoryId=" + InventoryId + ", localDate=" + localDate + ", vaccine=" + vaccine
				+ "]";
	}
	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vaccineInventory")
//	private List<VaccinationCenter> vaccinationCenter;
	
	
	

	
	
	
	

}
