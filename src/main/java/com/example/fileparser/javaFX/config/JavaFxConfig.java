package com.example.fileparser.javaFX.config;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.stage.FileChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaFxConfig {
    @Bean
    public FileChooser getFileChooser() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter anyFilter = new FileChooser.ExtensionFilter("Any files", "*.*");
        fileChooser.getExtensionFilters().add(csvFilter);
        fileChooser.getExtensionFilters().add(anyFilter);
        fileChooser.getExtensionFilters().add(txtFilter);
        fileChooser.setSelectedExtensionFilter(csvFilter);
        fileChooser.setInitialDirectory(new File("D:\\test-files"));
        return fileChooser;
    }

    @Bean
    public ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(4);
    }
}
