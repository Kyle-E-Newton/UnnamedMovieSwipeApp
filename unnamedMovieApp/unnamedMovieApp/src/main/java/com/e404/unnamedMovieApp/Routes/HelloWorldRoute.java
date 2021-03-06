package com.e404.unnamedMovieApp.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRoute {

    @GetMapping("/hello")
    public String helloWorldRoute() {
        return "Hello World!";
    }
}
