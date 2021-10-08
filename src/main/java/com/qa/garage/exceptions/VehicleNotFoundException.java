package com.qa.garage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No vehicle found with that id")
public class VehicleNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1631233067962819229L;

	public VehicleNotFoundException() {
		super();
	}

	public VehicleNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VehicleNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleNotFoundException(String message) {
		super(message);
	}

	public VehicleNotFoundException(Throwable cause) {
		super(cause);
	}

}
