package com.example.fileparser.mapper;

import com.example.fileparser.model.Entity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EntityMapperImpl implements EntityMapper {
    private static final String HEADER = "1,2,3,4,5" + System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public Entity mapToModel(String line) {
        String[] columns = line.split(",");
        return new Entity(columns[0], columns[1], columns[2], Integer.parseInt(columns[3]), columns[4]);
    }

    @Override
    public List<String> toStrings(List<Entity> entities) {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);

        for (Entity entity : entities) {
            String stringBuilder = entity.getFirst() + SEPARATOR +
                    entity.getSecond() + SEPARATOR +
                    entity.getThird() + SEPARATOR +
                    entity.getFourth() + SEPARATOR +
                    entity.getFifth() + System.lineSeparator();
            lines.add(stringBuilder);
        }

        return lines;
    }
}
