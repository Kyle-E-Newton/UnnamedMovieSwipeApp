package com.e404.unnamedMovieApp.Objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    @Getter @Setter private UUID uuid;
    @Getter @Setter private String username;
    @Getter @Setter private String email;
    @Getter @Setter private List<Movie> likedMovies;
    @Getter @Setter private List<Movie> dislikedMovies;
    @Getter @Setter private String bio;
    @Getter @Setter private String encodedPassword;
    @Getter @Setter private List<Conversation> conversations;

    public User(String username, String email, String bio, String encodedPassword) {
        uuid = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.likedMovies = new ArrayList<>();
        this.dislikedMovies = new ArrayList<>();
        this.bio = bio;
        this.encodedPassword = encodedPassword;
        this.conversations = new ArrayList<>();
    }
}
