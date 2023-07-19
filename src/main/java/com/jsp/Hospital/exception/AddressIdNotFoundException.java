package com.jsp.Hospital.exception;

public class AddressIdNotFoundException extends RuntimeException {
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AddressIdNotFoundException(String message)
	{
		super();
		this.message=message;
	}
	

}
