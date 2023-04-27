package org.jfs.drivein.bookingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/*
author kumar- 1.0.0
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnavailableTitleException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public UnavailableTitleException(String message) {
        super(message);
    }
}
