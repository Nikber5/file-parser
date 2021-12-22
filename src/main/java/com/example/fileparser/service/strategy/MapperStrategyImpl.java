package com.example.fileparser.service.strategy;

import com.example.fileparser.service.mapper.Mapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MapperStrategyImpl implements MapperStrategy {
    private final List<Mapper> mappers;

    public MapperStrategyImpl(List<Mapper> mappers) {
        this.mappers = mappers;
    }

    @Override
    public <T> Mapper<T> getMapper(Class<T> clazz) {
        return mappers.stream()
                .filter(m -> m.getType().equals(clazz))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find mapper for: " + clazz));
    }
}
