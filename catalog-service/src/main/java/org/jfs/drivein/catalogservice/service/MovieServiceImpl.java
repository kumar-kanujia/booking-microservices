package org.jfs.drivein.catalogservice.service;

import org.jfs.drivein.catalogservice.dao.MovieDao;
import org.jfs.drivein.catalogservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieServiceImpl implements MovieService{

    private MovieDao movieDao;

    @Autowired
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
