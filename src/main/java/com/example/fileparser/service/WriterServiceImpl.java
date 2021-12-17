package com.example.fileparser.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(Path path, List<String> lines) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String line : lines) {
                writer.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + path.getFileName(), e);
        }
    }
}
