package com.stg.exception;

public class RestaurantException extends RuntimeException {

	public RestaurantException() {

	}

	private String message;

	public RestaurantException(String message) {
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
