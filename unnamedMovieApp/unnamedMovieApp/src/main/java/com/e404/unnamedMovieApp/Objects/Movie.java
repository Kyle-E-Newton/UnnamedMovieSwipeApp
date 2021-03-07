package com.e404.unnamedMovieApp.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "movies")
public class Movie {

    @Getter @Setter private String title;
    @Getter @Setter private Date releaseDate;
    @Getter @Setter private String genre;
    @Getter @Setter private int duration;
    @Getter @Setter private String country;
    @Getter @Setter private String language;
    @Getter @Setter private String rating;

    public Movie(String title, Date releaseDate, String genre, int duration, String country, String language, String rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.duration = duration;
        this.country = country;
        this.language = language;
        this.rating = rating;
    }
}
