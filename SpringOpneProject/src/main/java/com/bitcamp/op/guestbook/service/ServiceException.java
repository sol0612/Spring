package com.bitcamp.op.guestbook.service;

public class ServiceException extends Exception {

	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

}
