package com.example.fileparser.service;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.model.ResultEntity;
import com.example.fileparser.model.TransactionRecord;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {
    @Override
    public List<ResultEntity> getResult(List<TransactionRecord> transactionRecords, List<CrmEntity> crmEntities) {
        crmEntities = crmEntities.stream().peek(c -> c.setWorkPhone(validatePhone(c.getWorkPhone())))
                .peek(c -> c.setWorkDirectPhone(validatePhone(c.getWorkDirectPhone())))
                .peek(c -> c.setMobilePhone(validatePhone(c.getMobilePhone())))
                .peek(c -> c.setHomePhone(validatePhone(c.getHomePhone())))
                .peek(c -> c.setAnotherPhone(validatePhone(c.getAnotherPhone())))
                .collect(Collectors.toList());
        List<ResultEntity> resultEntities = transactionRecords.stream()
                .map(this::mapToResult)
                .collect(Collectors.toList());
        resultEntities.addAll(crmEntities.stream()
                .map(this::mapToResult)
                .collect(Collectors.toList()));
        return resultEntities;
    }

    private ResultEntity mapToResult(TransactionRecord record) {
        return new ResultEntity(record.getId(), record.getClientName(), record.getPhoneNumber(), record.getEmail(),
                record.getGoods(), record.getSumOfPayment(), record.getTimeOfPayment(), record.getPaymentMethod(), record.getCardOwner(),
                record.getClientCountry(), record.getClientSurname(), null, null, null, null, null,
                null, null, null, null, null, null);
    }

    private ResultEntity mapToResult(CrmEntity entity) {
        return new ResultEntity(null, null,null, null,
                null, null, null, null, null,
                null, null, entity.getTableId(), entity.getId(), entity.getContactFullName(),
                entity.getWorkPhone(), entity.getWorkDirectPhone(), entity.getMobilePhone(), entity.getHomePhone(),
                entity.getAnotherPhone(), entity.getWorkEmail(), entity.getPersonalEmail(), entity.getAnotherEmail());
    }

    private String validatePhone(String phone) {
        if (phone == null || phone.equals("")) {
            return null;
        }
        char[] chars = phone.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                chars[i] = Character.MIN_VALUE;
            }
        }
        return new String(chars);
    }
}
