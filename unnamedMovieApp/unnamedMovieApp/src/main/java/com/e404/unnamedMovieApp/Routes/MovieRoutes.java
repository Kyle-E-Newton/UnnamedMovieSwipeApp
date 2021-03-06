package com.e404.unnamedMovieApp.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRoutes {

    public final String API = "/user/";

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
}
