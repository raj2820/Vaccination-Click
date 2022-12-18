package com.masai.model;

import javax.validation.constraints.NotNull;

public class VaccineCount {
	
	@NotNull(message="Quantity should not be 0")
	private Integer quantity;
	@NotNull(message="Quantity should not be null")
	private Double price;




	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}

public VaccineCount() {
	// TODO Auto-generated constructor stub
}

	@Override
	public String toString() {
		return "VaccineCount [quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
}
