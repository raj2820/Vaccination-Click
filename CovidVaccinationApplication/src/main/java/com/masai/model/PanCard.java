package com.masai.model;

import javax.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class PanCard {
	
	@Column(unique = true)
	private String panNo;

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public PanCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
