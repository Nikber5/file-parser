package com.example.fileparser.service.handler;

import com.example.fileparser.mapper.Mapper;
import com.example.fileparser.model.TransactionRecord;
import com.example.fileparser.service.ReaderService;
import java.io.File;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransactionFileHandlerImpl implements FileHandler<TransactionRecord> {
    private final ReaderService readerService;
    private final Mapper<TransactionRecord> mapper;

    public TransactionFileHandlerImpl(ReaderService readerService, Mapper<TransactionRecord> mapper) {
        this.readerService = readerService;
        this.mapper = mapper;
    }

    @Override
    public List<TransactionRecord> getEntitiesFromFile(File file) {
        List<String> lines = readerService.readSmallFile(file);
        return mapper.mapToModels(lines);
    }

    @Override
    public Class<TransactionRecord> getType() {
        return TransactionRecord.class;
    }
}
