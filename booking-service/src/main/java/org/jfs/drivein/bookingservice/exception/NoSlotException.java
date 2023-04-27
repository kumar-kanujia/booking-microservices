package org.jfs.drivein.bookingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSlotException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSlotException(String message) {
		super(message);
	}

}
