package org.jfs.drivein.catalogservice.resource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.jfs.drivein.catalogservice.exception.MovieTitleNotFoundException;
import org.jfs.drivein.catalogservice.model.Movie;
import org.jfs.drivein.catalogservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MovieResource {


    private final MovieService movieService;

    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("save")
    public ResponseEntity<Movie> saveMovie(@RequestBody @Valid Movie movie, HttpServletRequest request){
        movie = movieService.saveMovie(movie);
        URI uri = ServletUriComponentsBuilder.fromContextPath(request).path("view/{title}").buildAndExpand(movie.getTitle()).toUri();
        return ResponseEntity.created(uri).body(movie);
    }
    
    @PutMapping("update/{title}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String title, @RequestBody @Valid Movie movie ) throws MovieTitleNotFoundException {
    	movie = movieService.updateMovie(title, movie);
		return ResponseEntity.accepted().body(movie);
    }
    
    @GetMapping("view/{title}")
    public Movie viewMovie(@PathVariable String title) throws MovieTitleNotFoundException{
    	
    	return movieService.viewMovie(title);
    }
    
    @DeleteMapping("delete/{title}")
    public ResponseEntity<?> deleteMovie(@PathVariable String title) {
    	movieService.deleteMovie(title);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("view/all")
    public List<Movie> viewAllMovie(){
    	return movieService.viewAllMovie();
    }
}
