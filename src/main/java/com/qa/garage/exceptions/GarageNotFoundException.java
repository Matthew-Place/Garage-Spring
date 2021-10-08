package com.qa.garage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No garage found with that id")
public class GarageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3696522356861267093L;

	public GarageNotFoundException() {
		super();
	}

	public GarageNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GarageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public GarageNotFoundException(String message) {
		super(message);
	}

	public GarageNotFoundException(Throwable cause) {
		super(cause);
	}

}
