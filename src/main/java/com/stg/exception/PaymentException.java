package com.stg.exception;

public class PaymentException extends RuntimeException {

	public PaymentException() {

	}

	private String message;

	public PaymentException(String message) {
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