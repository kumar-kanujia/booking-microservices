package org.jfs.drivein.scheduleservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidScheduleDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
