package com.jsp.Hospital.exception;

public class HospitalIdNotFoundException extends RuntimeException {
	
	String message;

	public HospitalIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
