package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Member {

	
	private boolean dose1;
	private boolean dose2;
	private LocalDateTime dose1Date;
	private LocalDateTime dose2Date;
	public boolean isDose1() {
		return dose1;
	}
	public void setDose1(boolean dose1) {
		this.dose1 = dose1;
	}
	public boolean isDose2() {
		return dose2;
	}
	public void setDose2(boolean dose2) {
		this.dose2 = dose2;
	}
	public LocalDateTime getDose1Date() {
		return dose1Date;
	}
	public void setDose1Date(LocalDateTime dose1Date) {
		this.dose1Date = dose1Date;
	}
	public LocalDateTime getDose2Date() {
		return dose2Date;
	}
	public void setDose2Date(LocalDateTime dose2Date) {
		this.dose2Date = dose2Date;
	}
	
	
	
	
	
	
	
}
