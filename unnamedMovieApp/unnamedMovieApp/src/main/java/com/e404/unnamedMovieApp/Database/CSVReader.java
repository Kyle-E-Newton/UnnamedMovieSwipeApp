package com.e404.unnamedMovieApp.Database;

import com.e404.unnamedMovieApp.Objects.Movie;
import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


public class CSVReader {

    @Autowired
    IMovieRepository movieRepository;

    Logger log = LoggerFactory.getLogger(CSVReader.class);


    public Movie MovieFromRecord(List<String> line) {
        //log.info(line.get(6));
        Movie movie = new Movie();
        movie.setTitle(line.get(1));
        movie.setReleaseDate(line.get(2));
        movie.setGenre(line.get(5));
        movie.setDuration(Integer.valueOf(line.get(4).substring(0, line.get(4).indexOf(' '))));
        movie.setCountry("USA");
        movie.setLanguage("English");
        movie.setRating(line.get(6));
        movie.setDescription(line.get(7));
        return movie;
    }
}



