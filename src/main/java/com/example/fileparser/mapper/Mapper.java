package com.example.fileparser.mapper;

import java.util.List;

public interface Mapper<T> {
    List<T> mapToModels(List<String> lines);

    List<String> toStrings(List<T> entities);

}
