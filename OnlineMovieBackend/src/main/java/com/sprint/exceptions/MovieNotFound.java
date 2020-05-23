package com.sprint.exceptions;

@SuppressWarnings("serial")
public class MovieNotFound extends RuntimeException{

	public MovieNotFound(String msg) {
		super(msg);
	}
}
