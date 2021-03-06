package com.e404.unnamedMovieApp.Routes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoutes {

    @GetMapping
    public void GetUser() {
        return;
    }

    @DeleteMapping
    public void DeleteUser() {
        return;
    }

    @PostMapping
    public void EditUser() {
        return;
    }

    @PostMapping
    public void CreateUser() {
        return;
    }

}
