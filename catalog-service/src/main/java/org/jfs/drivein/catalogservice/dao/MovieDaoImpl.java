package org.jfs.drivein.catalogservice.dao;

import org.jfs.drivein.catalogservice.model.Movie;
import org.jfs.drivein.catalogservice.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public Movie updateMovie(Movie movie) {
        return moviesRepository.save(movie);
    }

    @Override
    public Movie viewMovie(String title) {
        return moviesRepository.findByTitle(title).get();
    }

    @Override
    public Movie deleteMovie(String title) {
        return moviesRepository.deleteMovieByTitle(title).get();
    }

    @Override
    public List<Movie> viewAllMovie() {
        return (List<Movie>) moviesRepository.findAll();
    }
}
