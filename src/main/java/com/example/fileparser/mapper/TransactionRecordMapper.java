package com.example.fileparser.mapper;

import com.example.fileparser.model.TransactionRecord;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TransactionRecordMapper implements Mapper<TransactionRecord> {
    private static final String TRANSACTION_RECORD_SEPARATOR = ";";

    @Override
    public List<TransactionRecord> mapToModels(List<String> lines) {
        List<TransactionRecord> recordList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] columns = line.split(TRANSACTION_RECORD_SEPARATOR, -1);
            TransactionRecord transactionRecord = new TransactionRecord((long) i, columns[0], columns[1], columns[2],
                    columns[3], columns[4], columns[5],
                    columns[6], columns[7], columns[8], columns[9]);
            recordList.add(transactionRecord);
        }
        return recordList;
    }

    @Override
    public List<String> toStrings(List<TransactionRecord> entities) {
        return null;
    }
}
