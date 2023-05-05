package org.jfs.driveinmovie.driveinmovieapp.resource;

import java.util.List;

import org.jfs.driveinmovie.driveinmovieapp.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "catalog-service", url = "${feign.client.catalog-service}")
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
