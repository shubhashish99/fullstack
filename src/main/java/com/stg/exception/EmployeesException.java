package com.stg.exception;

public class EmployeesException extends RuntimeException {

	public EmployeesException() {

	}

	private String message;

	public EmployeesException(String message) {

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
