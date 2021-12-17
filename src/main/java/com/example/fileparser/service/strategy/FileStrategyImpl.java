package com.example.fileparser.service.strategy;

import com.example.fileparser.service.handler.FileHandler;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class FileStrategyImpl implements FileStrategy {
    private final List<FileHandler> fileHandlers;

    public FileStrategyImpl(List<FileHandler> fileHandlers) {
        this.fileHandlers = fileHandlers;
    }

    @Override
    public <T> FileHandler<T> getHandler(Class<T> clazz) {
        Optional<FileHandler> fileHandlerOptional = fileHandlers.stream()
                .filter(h -> h.getType().equals(clazz))
                .findFirst();
        return (FileHandler<T>) fileHandlerOptional
                .orElseThrow(() -> new RuntimeException("There is no handler for " + clazz.getSimpleName()));
    }
}
