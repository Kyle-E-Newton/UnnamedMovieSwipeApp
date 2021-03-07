package com.e404.unnamedMovieApp.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.Date;

@Document(collection = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Getter @Setter private String title;
    @Getter @Setter private String releaseDate;
    @Getter @Setter private String genre;
    @Getter @Setter private int duration;
    @Getter @Setter private String country;
    @Getter @Setter private String language;
    @Getter @Setter private String rating;
    @Getter @Setter private String description;
}
