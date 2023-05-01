package org.jfs.driveinmovie.driveinmovieapp.controller;

import feign.FeignException;
import feign.RetryableException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.exception.MovieTitleNotFoundException;
import org.jfs.driveinmovie.driveinmovieapp.model.Movie;
import org.jfs.driveinmovie.driveinmovieapp.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("catalog")
    public String showCatalog(ModelMap modelMap){
        List<Movie> listAllMovie;
        try{
            listAllMovie = catalogService.listAllMovie();
            if (listAllMovie.size() == 0) {
                modelMap.put("error", "Database error check database");
            }
        }catch (RetryableException exception){
            modelMap.put("error", "Backend Sever error check Catalog Service");
            listAllMovie=new ArrayList<>();
        }
        modelMap.put("catalogList", listAllMovie);
        return "catalog";
    }

    @GetMapping("addMovie")
    public String showAddMoviePage(ModelMap modelMap){
        // To show page for adding the movie
        modelMap.put("movie", new Movie());
        return "addMovie";
    }

    @PostMapping(value = "saveMovie")
    public String addMovie(@ModelAttribute @Valid Movie movie , BindingResult result) throws MovieTitleNotFoundException {
        if (movie.getId().length()< 3){
            if (result.hasErrors()){
                return "addMovie";
            }
            movie.setId(null);
            catalogService.save(movie);
        }else{
            if (result.hasErrors()){
                return "redirect:/updateMovie?title=" + movie.getTitle();
            }
            catalogService.update(movie);
        }
        return "redirect:/adminCatalog";
    }

    @GetMapping(value = "updateMovie")
    public String updateMovie(@RequestParam String title, ModelMap modelMap) throws MovieTitleNotFoundException {
        modelMap.put("movie", catalogService.findMovieByTitle(title).get(0));
        return "updateMovie";
    }


    @PostMapping("searchMovie")
    public String searchMovie(@RequestParam String title, ModelMap modelMap) throws MovieTitleNotFoundException {
        List<Movie> movies;
        try {
            movies = catalogService.findMovieByTitle(title);
        } catch (FeignException exception) {
            movies = new ArrayList<>();
            modelMap.put("error", "Not Found");
        }
        modelMap.put("catalogList", movies);
        return "catalog";
    }

    @GetMapping(value = "adminCatalog")
    public String changeCatalog(ModelMap modelMap){
        modelMap.put("catalogList", catalogService.listAllMovie());
        return "adminCatalog";
    }

    @GetMapping("deleteMovie")
    public String deleteMovie(@RequestParam String title) throws MovieTitleNotFoundException {
        catalogService.deleteByTitle(title);
        return "redirect:/adminCatalog";
    }


}
