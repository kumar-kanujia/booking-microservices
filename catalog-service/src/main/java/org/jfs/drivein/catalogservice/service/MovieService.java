package org.jfs.drivein.catalogservice.service;

import org.jfs.drivein.catalogservice.exception.InvalidMovieTitleException;
import org.jfs.drivein.catalogservice.model.Movie;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie);
    Movie updateMovie(String title , Movie movie) throws InvalidMovieTitleException;
    Movie viewMovie(String title) throws InvalidMovieTitleException;
    void deleteMovie(String title);
    List<Movie> viewAllMovie();
}
