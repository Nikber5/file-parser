package com.example.fileparser.service.mapper;

import com.example.fileparser.model.CrmEntity;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("crmEntityMapper")
public class CrmEntityMapper implements Mapper<CrmEntity> {
    @Override
    public List<CrmEntity> mapToModels(List<String> lines) {
        // TODO: 21/12/2021 Create logic
        return null;
    }

    @Override
    public List<String> toStrings(List<CrmEntity> entities) {
        return null;
    }

    @Override
    public Class<CrmEntity> getType() {
        return CrmEntity.class;
    }
}
