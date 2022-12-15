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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Integer bookingId;
	private Long mobileNo;
	private LocalDateTime dateofbooking=LocalDateTime.now();
	
	@Enumerated
	private Slots slot;
	
	private boolean bookingStatus;

	
	
	
	
	
}
