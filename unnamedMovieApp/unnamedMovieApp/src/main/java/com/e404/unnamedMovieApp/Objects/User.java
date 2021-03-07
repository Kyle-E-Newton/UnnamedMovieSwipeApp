package com.e404.unnamedMovieApp.Objects;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "users")
public class User {

    @Getter @Setter public UUID uuid;
    @Getter @Setter public String username;
    @Getter @Setter public String email;
    @Getter @Setter public List<Movie> likedMovies;
    @Getter @Setter public List<Movie> dislikedMovies;
    @Getter @Setter public String bio;
    @JsonIgnore
    @Getter @Setter public String encodedPassword;
    @Getter @Setter public List<Conversation> conversations;

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
