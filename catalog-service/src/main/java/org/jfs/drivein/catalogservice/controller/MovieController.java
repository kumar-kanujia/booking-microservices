package org.jfs.drivein.catalogservice.controller;

import org.jfs.drivein.catalogservice.model.Movie;
import org.jfs.drivein.catalogservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("save")
    public Movie saveMovie(@RequestBody Movie movie){
        System.out.println(movie);
        return movieService.saveMovie(movie);
    }
}
