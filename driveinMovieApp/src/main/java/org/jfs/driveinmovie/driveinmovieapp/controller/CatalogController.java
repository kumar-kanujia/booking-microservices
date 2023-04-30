package org.jfs.driveinmovie.driveinmovieapp.controller;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.exception.MovieTitleNotFoundException;
import org.jfs.driveinmovie.driveinmovieapp.model.Movie;
import org.jfs.driveinmovie.driveinmovieapp.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("addMovie")
    public String showAddMoviePage(ModelMap modelMap){
        modelMap.put("movie", new Movie());
        return "addMovie";
    }

    @GetMapping(value = "updateMovie")
    public String updateMovie(@RequestParam String title, ModelMap modelMap) throws MovieTitleNotFoundException {
        modelMap.put("movie", catalogService.findMovieByTitle(title));
        return "updateMovie";
    }

    @PostMapping(value = "saveMovie")
    public String addMovie(@ModelAttribute Movie movie) throws MovieTitleNotFoundException {
        if (movie.getId().length()< 3){
            movie.setId(null);
            catalogService.save(movie);
        }else{
            catalogService.update(movie);
        }
        return "redirect:/adminCatalog";
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
    public String searchMovie(@RequestParam String title){
        System.out.println(title);
        return "catalog";
    }
}
