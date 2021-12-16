package com.example.fileparser.service;

import java.io.File;
import java.util.List;

public interface ReaderService {
    List<String> readSmallFile(File file);
}
