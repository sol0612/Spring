package com.bitcamp.op.guestbook.service;

public class InvalidMessagePasswordException extends Exception {
	public InvalidMessagePasswordException(String message) {
		super(message);
	}

	public InvalidMessagePasswordException() {
		// TODO Auto-generated constructor stub
	}
}