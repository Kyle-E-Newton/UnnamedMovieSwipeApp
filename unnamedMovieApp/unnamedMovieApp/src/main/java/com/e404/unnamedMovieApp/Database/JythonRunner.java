package com.e404.unnamedMovieApp.Database;

import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import org.junit.Test;
import org.python.jline.internal.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.python.util.PythonInterpreter;
import org.python.core.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

public class JythonRunner {

    Logger log = LoggerFactory.getLogger(JythonRunner.class);

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


