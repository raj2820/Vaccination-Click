package com.masai.model;

import javax.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class AadharCard {
	
	@Column(unique = true)
	private Long aadharNo;
	
	@Column(unique = true)
	private String fingerPrints;
	
	@Column(unique = true)
	private String irisScan;

	public AadharCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFingerPrints() {
		return fingerPrints;
	}

	public void setFingerPrints(String fingerPrints) {
		this.fingerPrints = fingerPrints;
	}

	public String getIrisScan() {
		return irisScan;
	}

	public void setIrisScan(String irisScan) {
		this.irisScan = irisScan;
	}

	public AadharCard(Long aadharNo, String fingerPrints, String irisScan) {
		super();
		this.aadharNo = aadharNo;
		this.fingerPrints = fingerPrints;
		this.irisScan = irisScan;
	}
	
	
}
