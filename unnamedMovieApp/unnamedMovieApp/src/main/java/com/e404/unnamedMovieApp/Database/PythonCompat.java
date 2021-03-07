package com.e404.unnamedMovieApp.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

public class PythonCompat {

    Logger log = LoggerFactory.getLogger(PythonCompat.class);

    public void TestPythonCode() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python", "unnamedMovieApp/unnamedMovieApp/src/main/java/com/e404/unnamedMovieApp/Python/train.py");
        pb.redirectErrorStream(true);
        Process p = pb.start();

        Reader reader = new InputStreamReader(p.getInputStream());
        BufferedReader bf = new BufferedReader(reader);
        String s;
        while((s = bf.readLine()) != null) {
            log.info(s);
        }
    }
}


