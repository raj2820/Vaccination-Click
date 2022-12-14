package com.masai.exception;

public class VaccineInventoryException extends RuntimeException{
	
	public VaccineInventoryException() {
		
	}
	
    public VaccineInventoryException(String msg) {
		super(msg);
	}

}
