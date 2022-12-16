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

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, @NotNull(message = "name is mandatory") String name,
			@NotNull(message = "mobileNo is mandatory") String mobileNo,
			@Email @NotNull(message = "email is mandatory") String email, String password) {
		super();
		UserId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", name=" + name + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	

}
