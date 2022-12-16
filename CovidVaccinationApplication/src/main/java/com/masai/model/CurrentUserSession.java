package com.masai.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Integer userId;
	
	private String uuid;
	
	private LocalDateTime localDtaeTime;

	public CurrentUserSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentUserSession(Integer userId, String uuid, LocalDateTime localDtaeTime) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.localDtaeTime = localDtaeTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLocalDtaeTime() {
		return localDtaeTime;
	}

	public void setLocalDtaeTime(LocalDateTime localDtaeTime) {
		this.localDtaeTime = localDtaeTime;
	}
	
	

}
