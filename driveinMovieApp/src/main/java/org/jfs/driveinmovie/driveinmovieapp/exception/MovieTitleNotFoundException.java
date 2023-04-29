package org.jfs.driveinmovie.driveinmovieapp.exception;

import java.io.Serial;

public class MovieTitleNotFoundException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public MovieTitleNotFoundException(String msg) {
        super(msg);
    }
}