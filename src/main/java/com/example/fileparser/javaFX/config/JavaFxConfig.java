package com.example.fileparser.javaFX.config;

import javafx.stage.FileChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaFxConfig {
    @Bean
    public FileChooser getFileChooser() {
        FileChooser fileChooser = new FileChooser();
        return new FileChooser();
    }
}
