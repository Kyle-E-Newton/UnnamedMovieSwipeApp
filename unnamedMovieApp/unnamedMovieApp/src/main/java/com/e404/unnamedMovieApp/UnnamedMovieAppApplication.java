package com.e404.unnamedMovieApp;

import com.e404.unnamedMovieApp.Database.PythonCompat;
import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import com.e404.unnamedMovieApp.Repository.IUserRepository;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
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

	public void readCSV() throws Exception {
		movieRepository.deleteAll();

		Reader reader = Files.newBufferedReader(Paths.get("unnamedMovieApp/unnamedMovieApp/src/main/resources/IMDb movies.csv"));
		List<String[]> list = new ArrayList<>();
		CSVReader csvReader = new CSVReader(reader);
		String[] line;
		csvReader.readNext();
		while((line = csvReader.readNext()) != null) {
			list.add(line);
		}
		com.e404.unnamedMovieApp.Database.CSVReader myCsvReader = new com.e404.unnamedMovieApp.Database.CSVReader();
		for(String[] l: list) {
			movieRepository.insert(myCsvReader.MovieFromRecord(Arrays.asList(l)));
		}
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("CSV");
		//readCSV();
		PythonCompat runner = new PythonCompat();
		runner.TestPythonCode();
	}
}
