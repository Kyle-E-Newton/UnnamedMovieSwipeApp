package com.e404.unnamedMovieApp.Routes;

import com.e404.unnamedMovieApp.Database.PythonCompat;
import com.e404.unnamedMovieApp.Objects.Movie;
import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import org.python.core.Py;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieRoutes {

    @Autowired
    IMovieRepository movieRepository;

    PythonCompat pythonCompat = new PythonCompat();

    public final String API = "/movie/";

    @GetMapping(API + "GetSingleMovie")
    public Movie GetSingleMovie(@RequestHeader String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @GetMapping(API + "GetMovieSet")
    public void GetMovieSet() {
        return;
    }

    @GetMapping(API + "GetMovieOnLikes")
    public List<Movie> GetMovieOnLikes() {
        try {
            return pythonCompat.GetAlgorithmOutput();
        } catch (Exception e) {

        }
        return null;
    }

    @GetMapping(API + "GetAllMovies")
    public List<Movie> GetAllMovies() {
        return movieRepository.findAll();
    }
}
