package org.jfs.driveinmovie.driveinmovieapp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private String id;
    @NotBlank(message = "Title can't be blank")
    private String title;
    @NotBlank(message="Genre can't be blank")
    private String genre;
    @NotBlank(message="Description can't be blank")
    private String description;
    @Min(value = 0, message = "Minimum value should be 0")
    @Max(value = 10, message = "Maximum value should be 10")
    private double rating;
}