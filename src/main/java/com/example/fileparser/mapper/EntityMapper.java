package com.example.fileparser.mapper;

import com.example.fileparser.model.Entity;
import java.util.List;

public interface EntityMapper {
    Entity mapToModel(String line);

    List<String> toStrings(List<Entity> entities);

}
