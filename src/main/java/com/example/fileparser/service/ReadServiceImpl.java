package com.example.fileparser.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReadServiceImpl implements ReaderService {
    @Override
    public List<String> readSmallFile(File file) {
        Path path = Paths.get(file.getPath());
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + file.getPath(), e);
        }
    }
}
