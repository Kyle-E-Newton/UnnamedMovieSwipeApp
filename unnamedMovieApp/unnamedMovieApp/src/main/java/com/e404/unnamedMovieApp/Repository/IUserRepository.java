package com.e404.unnamedMovieApp.Repository;

import com.e404.unnamedMovieApp.Objects.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
    User findUserByUUID(String UUID);
}
