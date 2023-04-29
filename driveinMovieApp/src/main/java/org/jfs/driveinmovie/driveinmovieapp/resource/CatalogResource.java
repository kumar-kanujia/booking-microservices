package org.jfs.driveinmovie.driveinmovieapp.resource;

import org.jfs.driveinmovie.driveinmovieapp.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogResource {

    private static final List<Movie> movieList = new ArrayList<>();

    static {
        movieList.add(new Movie("1", "Avenger", "Action", "Marvel Movie", 9));
        movieList.add(new Movie("2", "Avenger 1", "Action", "Marvel Movie", 9));
        movieList.add(new Movie("3", "Avenger 2", "Action", "Marvel Movie", 9));
    }


    public List<Movie> getAllMovie(){
        return movieList;
    }

    public void save(Movie movie) {
        movieList.add(movie);
    }

    public Movie findMovieById(String id) {
        return movieList.stream().filter(t-> t.getId().equals(id)).findFirst().orElseThrow();
    }

    public void deleteById(String id) {
        movieList.removeIf(t->t.getId().equals(id));
    }


}
