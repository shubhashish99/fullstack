package com.stg.exception;

public class SalesException extends RuntimeException {

	public SalesException() {

	}

	private String message;

	public SalesException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
