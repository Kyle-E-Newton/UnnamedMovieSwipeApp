package com.e404.unnamedMovieApp.Database;

import com.e404.unnamedMovieApp.Objects.Movie;
import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PythonCompat {

    Logger log = LoggerFactory.getLogger(PythonCompat.class);

    @Autowired
    IMovieRepository movieRepository;

    public List<Movie> GetAlgorithmOutput() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python", "unnamedMovieApp/unnamedMovieApp/src/main/java/com/e404/unnamedMovieApp/Python/train.py");
        pb.redirectErrorStream(true);
        Process p = pb.start();

        Reader reader = new InputStreamReader(p.getInputStream());
        BufferedReader bf = new BufferedReader(reader);

        String s;
        Movie m;
        List<Movie> movies = new ArrayList<>();
        List<String> values = new ArrayList<>();
        while((s = bf.readLine()) != null) {
            values.add(s);
        }

        for (String str: values) {
            System.out.println(str);
            //movies.add(movieRepository.findMovieByTitle(str));
        }


        return movies;
    }
}


