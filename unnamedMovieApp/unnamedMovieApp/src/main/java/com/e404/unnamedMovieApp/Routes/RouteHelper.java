package com.e404.unnamedMovieApp.Routes;

import com.e404.unnamedMovieApp.Objects.User;
import com.e404.unnamedMovieApp.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteHelper {

    @Autowired
    IUserRepository userRepository;

    @GetMapping("/user/all")
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}
