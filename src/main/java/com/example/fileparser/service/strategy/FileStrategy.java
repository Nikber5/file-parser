package com.example.fileparser.service.strategy;

import com.example.fileparser.service.handler.FileHandler;

public interface FileStrategy {
    <T> FileHandler<T> getHandler(Class<T> clazz);
}
