package com.example.fileparser.service;

import javafx.scene.control.TableView;

public interface TableService {
    <T> void tuneTable(TableView<T> tableView, Class<T> clazz);
}
