package org.jfs.drivein.catalogservice.service;

import java.util.List;

import org.jfs.drivein.catalogservice.dao.MovieDao;
import org.jfs.drivein.catalogservice.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceImpl implements MovieService{

    private MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieDao.saveMovie(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie viewMovie(String title) {
        return null;
    }

    @Override
    public Movie deleteMovie(String title) {
        return null;
    }

    @Override
    public List<Movie> viewAllMovie() {
        return null;
    }
}
