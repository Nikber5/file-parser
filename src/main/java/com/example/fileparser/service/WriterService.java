package com.example.fileparser.service;

import java.nio.file.Path;
import java.util.List;

public interface WriterService {
    void writeToFile(Path path, List<String> lines);
}
