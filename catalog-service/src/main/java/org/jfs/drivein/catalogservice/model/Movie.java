package org.jfs.drivein.catalogservice.model;

import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
author kumar-kanujia
 */

@Document
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Movie {

    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String genre;
    @NonNull
    private String description;
    @NonNull
    private int rating;

}
