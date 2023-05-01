package org.jfs.driveinmovie.driveinmovieapp.service;

import feign.FeignException.FeignClientException;
import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.exception.MovieTitleNotFoundException;
import org.jfs.driveinmovie.driveinmovieapp.model.Movie;
import org.jfs.driveinmovie.driveinmovieapp.resource.CatalogResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CatalogService {

    private  final CatalogResource catalogResource;

    public void save(Movie movie) {
        catalogResource.save(movie);
    }

    public List<Movie> listAllMovie(){
		List<Movie> list;
		try {
			list = catalogResource.getAllMovie();
		} catch (FeignClientException e) {
			list = new ArrayList<>();
		}
		return list;
    }

    public void update(Movie movie) throws MovieTitleNotFoundException {
        if (! catalogResource.updateMovie(movie.getTitle(), movie).getStatusCode().isSameCodeAs(HttpStatus.ACCEPTED))
            throw new MovieTitleNotFoundException("");
    }



    public List<Movie> findMovieByTitle(String title) throws MovieTitleNotFoundException {
        ResponseEntity<Movie> movieResponseEntity = catalogResource.findMovieByTitle(title);
        if (movieResponseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            throw new MovieTitleNotFoundException("");
        }
        return List.of(Objects.requireNonNull(movieResponseEntity.getBody()));
    }



    public void deleteByTitle(String title) throws MovieTitleNotFoundException {
        if (! catalogResource.deleteByTitle(title).getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT))
            throw new MovieTitleNotFoundException("");
    }
}
