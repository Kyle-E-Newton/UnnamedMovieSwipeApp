package com.e404.unnamedMovieApp.Repository;

import com.e404.unnamedMovieApp.Objects.Movie;
import com.e404.unnamedMovieApp.Objects.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMovieRepository extends MongoRepository<Movie, String> {
    Movie findMovieByTitle(String title);
}
