package org.jfs.drivein.catalogservice.service;

import org.jfs.drivein.catalogservice.dao.MovieDao;
import org.jfs.drivein.catalogservice.exception.MovieTitleNotFoundException;
import org.jfs.drivein.catalogservice.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieServiceImpl implements MovieService{

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieDao.saveMovie(movie);
    }

    @Override
    public Movie updateMovie(String title , Movie movie) throws MovieTitleNotFoundException {
    	Optional<Movie> movieOptional =  movieDao.viewMovie(title);
    	if(movieOptional.isEmpty()) {
    		throw new MovieTitleNotFoundException("");
    	}
    	movie.setId(movieOptional.get().getId());
        return movieDao.saveMovie(movie);
    }

    @Override
    public Movie viewMovie(String title) throws MovieTitleNotFoundException{
    	Optional<Movie> movieOptional =  movieDao.viewMovie(title);
    	if(movieOptional.isEmpty()) {
    		throw new MovieTitleNotFoundException("");
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
