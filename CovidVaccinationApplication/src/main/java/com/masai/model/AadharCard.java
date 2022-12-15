package com.masai.model;

import javax.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AadharCard {
	
	@Column(unique = true)
	private Long aadharNo;
	
	@Column(unique = true)
	private String fingerPrints;
	
	@Column(unique = true)
	private String irisScan;
}
