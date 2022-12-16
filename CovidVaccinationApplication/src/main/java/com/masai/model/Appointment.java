package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Integer bookingId;
	private Long mobileNo;
	private LocalDateTime dateofbooking=LocalDateTime.now();
	
	@Enumerated
	private Slots slot;
	
	private boolean bookingStatus;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDateTime getDateofbooking() {
		return dateofbooking;
	}

	public void setDateofbooking(LocalDateTime dateofbooking) {
		this.dateofbooking = dateofbooking;
	}

	public Slots getSlot() {
		return slot;
	}

	public void setSlot(Slots slot) {
		this.slot = slot;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Appointment(Integer bookingId, Long mobileNo, LocalDateTime dateofbooking, Slots slot,
			boolean bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.mobileNo = mobileNo;
		this.dateofbooking = dateofbooking;
		this.slot = slot;
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "Appointment [bookingId=" + bookingId + ", mobileNo=" + mobileNo + ", dateofbooking=" + dateofbooking
				+ ", slot=" + slot + ", bookingStatus=" + bookingStatus + "]";
	}

	
	
	
	
	
}
