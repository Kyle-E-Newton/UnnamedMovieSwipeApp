package com.e404.unnamedMovieApp.Database;

import com.e404.unnamedMovieApp.Repository.IMovieRepository;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.python.util.PythonInterpreter;
import org.python.core.*;

import static org.junit.Assert.assertEquals;

public class Jython {
    @Test
    public void givenPythonInterpreter_whenNumbersAdded_thenOutputDisplayed() {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.exec("train.py");
            PyObject x = pyInterp.get("x");
            assertEquals("x: ", 20, x.asInt());
        }
    }
}


