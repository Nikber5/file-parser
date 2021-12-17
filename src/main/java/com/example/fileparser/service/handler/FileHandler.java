package com.example.fileparser.service.handler;

import java.io.File;
import java.util.List;

public interface FileHandler<T> {
    List<T> getEntitiesFromFile(File file);

    Class<T> getType();
}
