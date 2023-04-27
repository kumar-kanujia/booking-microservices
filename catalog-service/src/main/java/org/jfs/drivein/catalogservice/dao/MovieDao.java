package org.jfs.drivein.catalogservice.dao;

import org.jfs.drivein.catalogservice.model.Movie;

import java.util.List;

public interface MovieDao {
    Movie saveMovie(Movie movie);
    Movie updateMovie(Movie movie);
    Movie viewMovie(String title);
    Movie deleteMovie(String title);
    List<Movie> viewAllMovie();
}
