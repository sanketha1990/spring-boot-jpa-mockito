package com.springboot.app.exception;

public class PersonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4656686344833017894L;
	private String errorMessage;

	public PersonException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public PersonException() {
		super();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
