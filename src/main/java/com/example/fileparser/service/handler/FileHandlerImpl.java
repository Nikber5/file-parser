package com.example.fileparser.service.handler;

import com.example.fileparser.service.ReaderService;
import com.example.fileparser.service.mapper.Mapper;
import com.example.fileparser.service.strategy.MapperStrategy;
import java.io.File;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileHandlerImpl implements FileHandler {
    private final ReaderService readerService;
    private final MapperStrategy mapperStrategy;

    public FileHandlerImpl(ReaderService readerService, MapperStrategy mapperStrategy) {
        this.readerService = readerService;
        this.mapperStrategy = mapperStrategy;
    }

    public <T> List<T> getEntitiesFromFile(File file, Class<T> clazz) {
        List<String> lines = readerService.readSmallFile(file);
        Mapper<T> mapper = mapperStrategy.getMapper(clazz);

        return mapper.mapToModels(lines);
    }
}
