package com.bouvet.exception;

public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable t) {
		super(t.getMessage(), t);
	}

	public AppException(String message, Throwable t) {
		super(message, t);
	}

}
