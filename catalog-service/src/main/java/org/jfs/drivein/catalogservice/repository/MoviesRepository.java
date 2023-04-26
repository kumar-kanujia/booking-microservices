package org.jfs.drivein.catalogservice.repository;

import org.jfs.drivein.catalogservice.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/*
author kumar-kanujia
 */
public interface MoviesRepository extends CrudRepository<Movie, String> {
    public Optional<Movie> findByTitle(String title);
    public Optional<Movie> deleteMovieByTitle(String title);
}
