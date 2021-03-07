package com.e404.unnamedMovieApp;

import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import com.e404.unnamedMovieApp.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnnamedMovieAppApplication {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IMovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(UnnamedMovieAppApplication.class, args);
	}



}
