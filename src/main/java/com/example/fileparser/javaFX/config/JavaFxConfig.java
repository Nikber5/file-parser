package com.example.fileparser.javaFX.config;

import javafx.stage.FileChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaFxConfig {
    @Bean
    public FileChooser getFileChooser() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        FileChooser.ExtensionFilter anyFilter = new FileChooser.ExtensionFilter("Any files", "*.*");
        fileChooser.getExtensionFilters().add(csvFilter);
        fileChooser.getExtensionFilters().add(anyFilter);
        fileChooser.setSelectedExtensionFilter(csvFilter);
        return fileChooser;
    }
}
