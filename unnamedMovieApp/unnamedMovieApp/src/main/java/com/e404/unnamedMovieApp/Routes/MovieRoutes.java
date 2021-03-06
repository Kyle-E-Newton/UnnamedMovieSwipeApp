package com.e404.unnamedMovieApp.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRoutes {

    @GetMapping
    public void GetSingleMovie() {
        return;
    }

    @GetMapping
    public void GetMovieSet() {
        return;
    }

    @GetMapping
    public void GetMovieOnLikes() {
        return;
    }
}
