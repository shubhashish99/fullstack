package com.stg.exception;

public class RestaurantTablesException extends RuntimeException {

	public RestaurantTablesException() {

	}

	private String message;

	public RestaurantTablesException(String message) {
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
