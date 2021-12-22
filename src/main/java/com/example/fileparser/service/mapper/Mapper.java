package com.example.fileparser.service.mapper;

import java.util.List;

public interface Mapper<T> {
    List<T> mapToModels(List<String> lines);

    List<String> toStrings(List<T> entities);

    Class<T> getType();

}
