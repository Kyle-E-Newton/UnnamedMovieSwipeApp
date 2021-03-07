package com.e404.unnamedMovieApp.Request;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRequest {

    public String username;
    public String email;
    public String bio;
    public String encodedPassword;
}
