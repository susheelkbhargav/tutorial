package com.example.exception;

public class InvalidPageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPageException(int page, int maxPages) {
		// TODO Auto-generated constructor stub
		super("Invalid page Number " + page + ", maxPages: " + maxPages);
	}

}
