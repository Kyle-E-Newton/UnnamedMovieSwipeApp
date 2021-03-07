package com.e404.unnamedMovieApp;

import com.e404.unnamedMovieApp.Database.CSVReader;
import com.e404.unnamedMovieApp.Objects.Movie;
import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import com.e404.unnamedMovieApp.Repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UnnamedMovieAppApplication implements CommandLineRunner {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IMovieRepository movieRepository;

	Logger logger = LoggerFactory.getLogger(UnnamedMovieAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UnnamedMovieAppApplication.class, args);
	}

	public void readCSV() {
		logger.info("Read CSV Bean");
		try (BufferedReader br = new BufferedReader(new FileReader("imdb_top_1000.csv"))) {

			List<List<String>> result = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				result.add(Arrays.asList(values));
			}

			System.out.println(result);
		}
		catch (Exception e) {

		}
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("CSV");
		readCSV();
	}
}
