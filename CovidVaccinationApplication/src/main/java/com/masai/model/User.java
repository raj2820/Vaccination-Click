 package com.masai.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserId;
	
	
	@NotNull(message="name is mandatory")
	private String name;
	
	@NotNull(message="mobileNo is mandatory")
	private String mobileNo;
	
	@Email
	@NotNull(message="email is mandatory")
	private String email;
	
	@Column(unique = true)
	private String password;

}
