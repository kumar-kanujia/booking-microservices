package org.jfs.drivein.catalogservice.service;

import org.jfs.drivein.catalogservice.dao.MovieDao;
import org.jfs.drivein.catalogservice.exception.InvalidMovieTitleException;
import org.jfs.drivein.catalogservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Movie updateMovie(String title , Movie movie) throws InvalidMovieTitleException {
    	Optional<Movie> movieOptional =  movieDao.viewMovie(title);
    	if(movieOptional.isEmpty()) {
    		throw new InvalidMovieTitleException();
    	}
    	movie.setId(movieOptional.get().getId());
        return movieDao.saveMovie(movie);
    }

    @Override
    public Movie viewMovie(String title) throws InvalidMovieTitleException{
    	Optional<Movie> movieOptional =  movieDao.viewMovie(title);
    	if(movieOptional.isEmpty()) {
    		throw new InvalidMovieTitleException();
    	}
        return movieOptional.get();
    }

    @Override
    public void deleteMovie(String title){
    	
    	movieDao.deleteMovie(title);
    }

    @Override
    public List<Movie> viewAllMovie() {
        return movieDao.viewAllMovie();
    }
}
