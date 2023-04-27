package org.jfs.drivein.catalogservice.resource;

import java.util.List;

import org.jfs.drivein.catalogservice.exception.InvalidMovieTitleException;
import org.jfs.drivein.catalogservice.model.Movie;
import org.jfs.drivein.catalogservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @PostMapping("save")
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }
    
    @PutMapping("update/{title}")
    public Movie updateMovie(@RequestBody Movie movie , @PathVariable String title) throws InvalidMovieTitleException {
    	
		return movieService.updateMovie(title, movie);	
    }
    
    @GetMapping("view/{title}")
    public Movie viewMovie(@PathVariable String title) throws InvalidMovieTitleException{
    	
    	return movieService.viewMovie(title);
    }
    
    @DeleteMapping("delete/{title}")
    public void deleteMovie(@PathVariable String title) {
    	movieService.deleteMovie(title);
    }
    
    @GetMapping("view/all")
    public List<Movie> viewAllMovie(){
    	return movieService.viewAllMovie();
    }
}
