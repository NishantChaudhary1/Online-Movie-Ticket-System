package com.sprint.exceptions;

@SuppressWarnings("serial")
public class MovieAlreadyPresent extends RuntimeException {

	public MovieAlreadyPresent(String msg) {
		super(msg);
	}
}
