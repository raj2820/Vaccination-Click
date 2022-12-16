package com.masai.model;


import javax.persistence.Embeddable;

@Embeddable
public class PanCard {
	

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
