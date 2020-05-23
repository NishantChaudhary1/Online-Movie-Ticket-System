package com.sprint.exceptions;

@SuppressWarnings("serial")
public class ShowNotFound extends RuntimeException{

	public ShowNotFound(String msg) {
		super(msg);
	}
}
