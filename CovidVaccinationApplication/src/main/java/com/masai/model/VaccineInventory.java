package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class VaccineInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer InventoryId;
	
	private LocalDate localDate;
	
	

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
	
	
	

}
