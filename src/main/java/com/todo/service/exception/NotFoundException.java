package com.todo.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	
	 public NotFoundException() {
	        super();
	        this.httpStatus = HttpStatus.NOT_FOUND;
	    }

	    public NotFoundException(String message) {
	        super(message);
	        this.httpStatus = HttpStatus.NOT_FOUND;
	    }

	    public NotFoundException(Throwable cause) {
	        super(cause);
	        this.httpStatus = HttpStatus.NOT_FOUND;
	    }

	    public NotFoundException(HttpStatus httpStatus, String message) {
	        super(message);
	        this.httpStatus = httpStatus;
	    }

	    public NotFoundException(String message, Throwable cause) {
	        super(message, cause);
	        this.httpStatus = HttpStatus.NOT_FOUND;
	    }

	    public NotFoundException(HttpStatus httpStatus, String message, Throwable cause) {
	        super(message, cause);
	        this.httpStatus = httpStatus;
	    }

	    public HttpStatus getHttpStatus() {
	        return httpStatus;
	    }
}
