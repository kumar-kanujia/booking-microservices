package org.jfs.driveinmovie.driveinmovieapp.service;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.model.Movie;
import org.jfs.driveinmovie.driveinmovieapp.resource.CatalogResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService {

    private final CatalogResource catalogResource;

    public List<Movie> listAllMovie(){
        return catalogResource.getAllMovie();
    }

    public void save(Movie movie) {
        catalogResource.save(movie);
    }

    public Movie findMovieById(String id) {
       return catalogResource.findMovieById(id);
    }

    public void deleteById(String id) {
        catalogResource.deleteById(id);
    }
}
