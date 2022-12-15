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
public class PanCard {
	
	@Column(unique = true)
	private String panNo;
	
}
