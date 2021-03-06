package com.e404.unnamedMovieApp.Routes;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserRoutes {

    public final String API = "/user/";

    @GetMapping(API + "GetUser")
    public void GetUser() {
        return;
    }

    @DeleteMapping(API + "DeleteUser")
    public void DeleteUser() {
        return;
    }

    @PutMapping(API + "EditUser")
    public void EditUser() {
        return;
    }

    @PutMapping(API + "CreateUser")
    public void CreateUser() {
        return;
    }

    @PostMapping(API + "LikeMovie")
    public void LikeMovie() {
        return;
    }

    @PostMapping(API + "DislikeMovie")
    public void DislikeMovie() {
        return;
    }

    @PostMapping(API + "SkipMovie")
    public void SkipMovie() {
        return;
    }
}
