package com.example.fileparser.service;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.model.TransactionRecord;
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
    public <T> void tuneTable(TableView<T> tableView, Class<T> clazz) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Map<String, String> titleFieldMap = null;
        if (clazz.equals(CrmEntity.class)) {
            titleFieldMap = getCrmEntityProperties();
        } else if (clazz.equals(TransactionRecord.class)) {
            titleFieldMap = getTransactionRecordProperties();
        }

        if (titleFieldMap != null) {
            titleFieldMap.forEach((title, field) -> {
                TableColumn<T, String> tableColumn = new TableColumn<>(title);
                tableColumn.setCellValueFactory(new PropertyValueFactory<>(field));
                tableView.getColumns().add(tableColumn);
            });
        }
    }

    private Map<String, String> getTransactionRecordProperties() {
        Map<String, String> titleFieldMap = new LinkedHashMap<>();
        titleFieldMap.put("#", "id");
        titleFieldMap.put("Имя клиента", "clientName");
        titleFieldMap.put("Телефон", "phoneNumber");
        titleFieldMap.put("Email", "email");
        titleFieldMap.put("Товары", "goods");
        titleFieldMap.put("Сумма", "sumOfPayment");
        titleFieldMap.put("Время платежа", "timeOfPayment");
        titleFieldMap.put("Способ оплаты", "paymentMethod");
        titleFieldMap.put("Владелец карты", "cardOwner");
        titleFieldMap.put("Страна Клиента", "clientCountry");
        titleFieldMap.put("Фамилия клиента", "clientSurname");
        return titleFieldMap;
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
