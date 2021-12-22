package com.example.fileparser.service;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.model.TransactionRecord;
import com.example.fileparser.util.CsvUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {
    @Override
    public void tuneTransactionRecordTable(TableView<TransactionRecord> table) {
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn<TransactionRecord, String> idColumn = new TableColumn<>("#");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<TransactionRecord, String> clientNameColumn = new TableColumn<>("Имя клиента");
        clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("clientName"));

        TableColumn<TransactionRecord, String> phoneNumberColumn = new TableColumn<>("Телефон");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<TransactionRecord, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<TransactionRecord, String> goodsColumn = new TableColumn<>("Товары");
        goodsColumn.setCellValueFactory(new PropertyValueFactory<>("goods"));

        TableColumn<TransactionRecord, String> sumOfPaymentColumn = new TableColumn<>("Сумма");
        sumOfPaymentColumn.setCellValueFactory(new PropertyValueFactory<>("sumOfPayment"));

        TableColumn<TransactionRecord, String> timeOfPaymentColumn = new TableColumn<>("Время платежа");
        timeOfPaymentColumn.setCellValueFactory(new PropertyValueFactory<>("timeOfPayment"));

        TableColumn<TransactionRecord, String> paymentMethodColumn = new TableColumn<>("Способ оплаты");
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

        TableColumn<TransactionRecord, String> cardOwnerColumn = new TableColumn<>("Владелец карты");
        cardOwnerColumn.setCellValueFactory(new PropertyValueFactory<>("cardOwner"));

        TableColumn<TransactionRecord, String> clientCountryColumn = new TableColumn<>("Страна Клиента");
        clientCountryColumn.setCellValueFactory(new PropertyValueFactory<>("clientCountry"));

        TableColumn<TransactionRecord, String> clientSurnameColumn = new TableColumn<>("Фамилия клиента");
        clientSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("clientSurname"));

        table.getColumns().addAll(idColumn, clientNameColumn, phoneNumberColumn, emailColumn,
                goodsColumn, sumOfPaymentColumn, timeOfPaymentColumn,
                paymentMethodColumn, cardOwnerColumn, clientCountryColumn, clientSurnameColumn);
    }

    @Override
    public void tuneCrmEntityTable(TableView<CrmEntity> tableView) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Map<String, String> titleFieldMap = getCrmEntityProperties();
        titleFieldMap.forEach((title, field) -> {
            TableColumn<CrmEntity, String> tableColumn = new TableColumn<>(title);
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field));
            tableView.getColumns().add(tableColumn);
        });

    }

    private Map<String, String> getCrmEntityProperties() {
        Map<String, String> titleFieldMap = new LinkedHashMap<>();
        titleFieldMap.put("ID", "id");
        titleFieldMap.put("Полное имя контакта", "contactFullName");
        titleFieldMap.put("Рабочий телефон", "workPhone");
        titleFieldMap.put("Рабочий прямой телефон", "workDirectPhone");
        titleFieldMap.put("Мобильный телефон", "mobilePhone");
        titleFieldMap.put("Домашний телефон", "homePhone");
        titleFieldMap.put("Другой телефон", "anotherPhone");
        titleFieldMap.put("Рабочий email", "workEmail");
        titleFieldMap.put("Личный email", "personalEmail");
        titleFieldMap.put("Другой email", "anotherEmail");
        return titleFieldMap;
    }
}
