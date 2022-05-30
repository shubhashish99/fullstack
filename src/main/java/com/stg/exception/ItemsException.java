package com.stg.exception;

public class ItemsException extends RuntimeException {

	public ItemsException() {

	}

	private String message;

	public ItemsException(String message) {

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
