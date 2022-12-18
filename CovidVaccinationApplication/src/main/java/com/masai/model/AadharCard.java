package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class AadharCard {
	


	@NotNull(message = "Aadhar Card should not be null")
	@Column(unique = true)
	private Long aadharNo;
	
	@NotNull(message = "Finger Prints should not be null")
	@Column(unique = true)
	private String fingerPrints;
	
	@NotNull(message = "Iris Scan should not be null")
	@Column(unique = true)
	private String irisScan;
	

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
	
	
	public AadharCard() {
		// TODO Auto-generated constructor stub
	}

}
