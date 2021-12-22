package com.example.fileparser.service.mapper;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.util.CsvUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("crmEntityMapper")
public class CrmEntityMapper implements Mapper<CrmEntity> {
    private static final String AMOCRM_SEPARATOR = ",";
    @Override
    public List<CrmEntity> mapToModels(List<String> lines) {
        List<CrmEntity> crmEntities = new ArrayList<>(lines.size() - 1);

        List<String> header = List.of(lines.get(0).split(AMOCRM_SEPARATOR, -1));
        int id = header.indexOf(CsvUtil.ID);
        int contactFullName = header.indexOf(CsvUtil.CONTACT_FULL_NAME);
        int workPhone = header.indexOf(CsvUtil.WORK_PHONE);
        int workDirectPhone = header.indexOf(CsvUtil.WORK_DIRECT_PHONE);
        int mobilePhone = header.indexOf(CsvUtil.MOBILE_PHONE);
        int homePhone = header.indexOf(CsvUtil.HOME_PHONE);
        int otherPhone = header.indexOf(CsvUtil.OTHER_PHONE);
        int workEmail = header.indexOf(CsvUtil.WORK_EMAIL);
        int personalEmail = header.indexOf(CsvUtil.PERSONAL_EMAIL);
        int otherEmail = header.indexOf(CsvUtil.OTHER_EMAIL);

        for (int i = 1; i < lines.size(); i++) {
            List<String> line = List.of(lines.get(i).split(AMOCRM_SEPARATOR, -1));
            try {
                CrmEntity crmEntity = new CrmEntity((long) i, Long.parseLong(line.get(id)), line.get(contactFullName),
                        line.get(workPhone), line.get(workDirectPhone), line.get(mobilePhone), line.get(homePhone),
                        line.get(otherPhone), line.get(workEmail), line.get(personalEmail), line.get(otherEmail));
                crmEntities.add(crmEntity);
                System.out.println(crmEntities);
            } catch (Exception e) {
                System.out.println("Can't parse entity on line number " + i);
            }
        }
        return crmEntities;
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
