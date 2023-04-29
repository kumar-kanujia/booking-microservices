package org.jfs.driveinmovie.driveinmovieapp.resource;

import org.jfs.driveinmovie.driveinmovieapp.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "catalog-service", url = "http://localhost:8010/")
public interface CatalogResource {

    @GetMapping("view")
    List<Movie> getAllMovie();

    @PostMapping("save")
    ResponseEntity<Movie> save(@RequestBody Movie movie);

    @PutMapping("update/{title}")
    ResponseEntity<Movie> updateMovie(@PathVariable String title, @RequestBody Movie movie);

    @GetMapping("view/{title}")
    ResponseEntity<Movie>  findMovieByTitle(@PathVariable String title);

    @DeleteMapping("delete/{title}")
    ResponseEntity<?> deleteByTitle(@PathVariable String title);

}
