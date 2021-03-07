package com.e404.unnamedMovieApp.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadCSV {

    private final static String COMMA_DELIMITER = ",";

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/imdb_top_1000.csv"))) {

            List<List<String>> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                result.add(Arrays.asList(values));
            }

            System.out.println(result);

    }
}



