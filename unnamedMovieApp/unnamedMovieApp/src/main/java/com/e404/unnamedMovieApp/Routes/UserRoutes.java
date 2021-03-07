package com.e404.unnamedMovieApp.Routes;

import com.e404.unnamedMovieApp.Objects.User;
import com.e404.unnamedMovieApp.Repository.IUserRepository;
import com.e404.unnamedMovieApp.Request.UserRequest;
import com.e404.unnamedMovieApp.Response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRoutes {

    Logger logger = LoggerFactory.getLogger(UserRoutes.class);

    public final String API = "/user/";

    @Autowired
    IUserRepository userRepository;

    @GetMapping(API + "GetUser")
    public User GetUser(@RequestHeader String UUID) {
        return userRepository.findUserByuuid(UUID);
    }

    @GetMapping(API + "GetUserByEmailPassword")
    public User GetUserByEmailPassword(@RequestHeader String email, @RequestHeader String password) {
        return userRepository.findUserByEmailAndEncodedPassword(email, password);
    }

    @DeleteMapping(API + "DeleteUser")
    public ResponseEntity<?> DeleteUser(@RequestHeader String UUID) {
        userRepository.deleteUserByuuid(UUID);
        return ResponseEntity.ok(new ApiResponse(true, "Deleted user " + UUID));
    }

    @PutMapping(API + "EditUser")
    public ResponseEntity<?> EditUser(@RequestHeader User user) {
        User got = userRepository.findUserByuuid(user.uuid.toString());
        if(got != null) {
            userRepository.deleteUserByuuid(user.uuid.toString());
            userRepository.insert(user);
            return ResponseEntity.ok(new ApiResponse(true, "Updated user " + user.uuid.toString()));
        }
        return ResponseEntity.ok(new ApiResponse(false, "Could not find user " + user.uuid.toString()));
    }

    @PutMapping(API + "CreateUser")
    public ResponseEntity<?> CreateUser(@RequestBody UserRequest userRequest) {
        logger.debug("Creating New User");
        User newUser = new User(userRequest.username, userRequest.email, userRequest.bio, userRequest.encodedPassword);
        //Sanity Check
        if(userRepository.findUserByuuid(newUser.uuid.toString()) == null) {
            userRepository.insert(newUser);
            return ResponseEntity.ok(new ApiResponse(true, "Created user " + newUser.uuid.toString()));
        }
        return ResponseEntity.ok(new ApiResponse(false, "Could not create user " + newUser.uuid.toString()));
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
