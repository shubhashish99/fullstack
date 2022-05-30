package com.stg.exception;

public class CustomerException extends RuntimeException {

	public CustomerException() {
	}

	private String message;

	public CustomerException(String message) {

		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
