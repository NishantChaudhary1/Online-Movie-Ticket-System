package com.sprint.exceptions;

@SuppressWarnings("serial")
public class TheaterNotFoundException extends RuntimeException {

	public TheaterNotFoundException(String msg) {
		super(msg);
	}
}
