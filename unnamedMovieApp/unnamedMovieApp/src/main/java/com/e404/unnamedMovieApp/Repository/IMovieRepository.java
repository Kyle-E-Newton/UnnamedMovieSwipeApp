package com.e404.unnamedMovieApp.Repository;

import com.e404.unnamedMovieApp.Objects.Movie;
import com.e404.unnamedMovieApp.Objects.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends MongoRepository<Movie, String> {
    Movie findMovieByTitle(String title);
}
