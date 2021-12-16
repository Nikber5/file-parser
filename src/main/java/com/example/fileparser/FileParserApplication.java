package com.example.fileparser;

import com.example.fileparser.javaFX.JavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileParserApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }
}
