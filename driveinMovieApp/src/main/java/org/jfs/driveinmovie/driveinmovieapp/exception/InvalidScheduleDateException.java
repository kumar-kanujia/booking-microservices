package org.jfs.driveinmovie.driveinmovieapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/*
author kumar-kaunjia
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidScheduleDateException extends Exception {

	@Serial
	private static final long serialVersionUID = 1L;
	
	public InvalidScheduleDateException(String msg) {
		super(msg);
	}
}
