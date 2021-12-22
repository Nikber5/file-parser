package com.example.fileparser.service.strategy;

import com.example.fileparser.service.mapper.Mapper;

public interface MapperStrategy {
    <T> Mapper<T> getMapper(Class<T> clazz);
}
