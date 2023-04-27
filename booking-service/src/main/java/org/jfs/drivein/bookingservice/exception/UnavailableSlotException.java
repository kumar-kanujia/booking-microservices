package org.jfs.drivein.bookingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/*
author kumar-kanujia
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnavailableSlotException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;
    public UnavailableSlotException(String message) {
        super(message);
    }
}
