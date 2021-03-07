package com.e404.unnamedMovieApp.Database;

import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.python.util.PythonInterpreter;
import org.python.core.*;

import static org.junit.Assert.assertEquals;

public class JythonRunner {

    public void TestPythonCode() {
        try(PythonInterpreter interpreter = new PythonInterpreter()) {
            interpreter.exec("print('Hello World')");
        }
    }
}


