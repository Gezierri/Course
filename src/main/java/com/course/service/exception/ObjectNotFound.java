package com.course.service.exception;

public class ObjectNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFound (Object id) {
		super("Resource not found. Id " + id );
	}
}
