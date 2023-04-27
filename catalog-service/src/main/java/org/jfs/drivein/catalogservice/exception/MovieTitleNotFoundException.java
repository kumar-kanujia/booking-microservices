package org.jfs.drivein.catalogservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieTitleNotFoundException extends Exception{

	@Serial
	private static final long serialVersionUID = 1L;

	public MovieTitleNotFoundException(String msg) {
		super(msg);
	}
}
