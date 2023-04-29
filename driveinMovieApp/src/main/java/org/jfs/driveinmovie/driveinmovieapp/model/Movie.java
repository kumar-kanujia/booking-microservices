package org.jfs.driveinmovie.driveinmovieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movie {

    private String id;
    private String title;
    private String genre;
    private String description;
    private double rating;

}