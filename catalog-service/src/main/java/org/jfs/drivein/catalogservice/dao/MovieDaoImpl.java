package org.jfs.drivein.catalogservice.dao;

import org.jfs.drivein.catalogservice.model.Movie;
import org.jfs.drivein.catalogservice.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieDaoImpl implements MovieDao {


    private final MoviesRepository moviesRepository;

    @Autowired
    public MovieDaoImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return moviesRepository.save(movie);
    }


    @Override
    public Optional<Movie> viewMovie(String title) {
        return moviesRepository.findByTitle(title);
    }

    @Override
    public void deleteMovie(String title) {
        moviesRepository.deleteMovieByTitle(title);
    }

    @Override
    public List<Movie> viewAllMovie() {
        return moviesRepository.findAll();
    }
}
