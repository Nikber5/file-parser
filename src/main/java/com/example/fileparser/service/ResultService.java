package com.example.fileparser.service;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.model.ResultEntity;
import com.example.fileparser.model.TransactionRecord;
import java.util.List;

public interface ResultService {
    List<ResultEntity> getResult(List<TransactionRecord> transactionRecords, List<CrmEntity> crmEntities);
}
