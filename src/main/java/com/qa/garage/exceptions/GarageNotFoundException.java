package com.qa.garage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No garage found with that id")
public class NoGarageFoundException extends RuntimeException {

	private static final long serialVersionUID = 3696522356861267093L;

	public NoGarageFoundException() {
		super();
	}

	public NoGarageFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoGarageFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoGarageFoundException(String message) {
		super(message);
	}

	public NoGarageFoundException(Throwable cause) {
		super(cause);
	}

}
