package org.jfs.drivein.catalogservice.dao;

import org.jfs.drivein.catalogservice.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    Movie saveMovie(Movie movie);
    Optional<Movie> viewMovie(String title);
    void deleteMovie(String title);
    List<Movie> viewAllMovie();
}
