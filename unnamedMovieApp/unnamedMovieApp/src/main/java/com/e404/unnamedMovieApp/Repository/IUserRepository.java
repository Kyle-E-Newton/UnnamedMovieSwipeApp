package com.e404.unnamedMovieApp.Repository;

import com.e404.unnamedMovieApp.Objects.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    User findUserByuuid(String uuid);
}
