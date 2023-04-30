package org.jfs.driveinmovie.driveinmovieapp.controller;

import jakarta.validation.Valid;
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

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("addMovie")
    public String showAddMoviePage(ModelMap modelMap){
        //To show page for adding th movie
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

    @GetMapping("catalog")
    public String showCatalog(ModelMap modelMap){
        modelMap.put("catalogList", catalogService.listAllMovie());
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

    @PostMapping("searchMovie")
    public String searchMovie(@RequestParam String title, ModelMap modelMap) throws MovieTitleNotFoundException {
        modelMap.put("catalogList", catalogService.findMovieByTitle(title));
        return "catalog";
    }
}