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
    @NotBlank(message = "")
    private String title;
    @NotBlank(message="")
    private String genre;
    @NotBlank(message="")
    private String description;
    @Min(value = 0, message = "")
    @Max(value = 10, message = "")
    private double rating;

}
