package com.stg.exception;

public class OrdersException extends RuntimeException {

	public OrdersException() {

	}

	private String message;

	public OrdersException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
