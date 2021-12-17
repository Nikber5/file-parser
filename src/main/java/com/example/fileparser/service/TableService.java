package com.example.fileparser.service;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.model.TransactionRecord;
import javafx.scene.control.TableView;

public interface TableService {
    void tuneTransactionRecordTable(TableView<TransactionRecord> tableView);

    void tuneCrmEntityTable(TableView<CrmEntity> tableView);
}
