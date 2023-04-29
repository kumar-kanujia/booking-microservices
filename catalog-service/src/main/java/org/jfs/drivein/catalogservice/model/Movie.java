package org.jfs.drivein.catalogservice.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
author kumar-kanujia
 */

@Document
@Getter
@Setter
@AllArgsConstructor
public class Movie {

    @Id
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
    public Movie() {
    }
}
