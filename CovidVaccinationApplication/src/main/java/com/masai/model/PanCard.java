package com.masai.model;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PanCard {
	

	@NotNull(message = "PanCard should not be null")
	private String panNo;



	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public PanCard(String panNo) {
		super();
		this.panNo = panNo;
	}

	public PanCard() {
		super();
	}

	


	
}
