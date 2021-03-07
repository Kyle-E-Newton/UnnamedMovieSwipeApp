package com.e404.unnamedMovieApp.Routes;

import com.e404.unnamedMovieApp.Objects.Movie;
import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRoutes {

    @Autowired
    IMovieRepository movieRepository;

    public final String API = "/movie/";

    @GetMapping(API + "GetSingleMovie")
    public void GetSingleMovie() {
        return;
    }

    @GetMapping(API + "GetMovieSet")
    public void GetMovieSet() {
        return;
    }

    @GetMapping(API + "GetMovieOnLikes")
    public void GetMovieOnLikes() {
        return;
    }

    @GetMapping(API + "GetAllMovies")
    public List<Movie> GetAllMovies() {
        return movieRepository.findAll();
    }
}
