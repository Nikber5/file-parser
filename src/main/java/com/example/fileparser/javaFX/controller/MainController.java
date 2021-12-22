package com.example.fileparser.javaFX.controller;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.model.ResultEntity;
import com.example.fileparser.model.TransactionRecord;
import com.example.fileparser.service.ResultService;
import com.example.fileparser.service.TableService;
import com.example.fileparser.service.WriterService;
import com.example.fileparser.service.handler.FileHandler;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.annotation.PreDestroy;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-stage.fxml")
public class MainController implements Initializable {
    private final ExecutorService executorService;

    private final TableService tableService;
    private final FileHandler fileHandler;
    private final ResultService resultService;
    private final WriterService writerService;
    private final FileChooser fileChooser;

    @FXML
    private Label transactionPathLabel;
    @FXML
    private Button transactionFileChooserButton;
    @FXML
    private ProgressIndicator transactionProgressIndicator;
    @FXML
    private Label crmPathLabel;
    @FXML
    private Button crmFileChooserButton;
    @FXML
    private ProgressIndicator crmProgressIndicator;
    @FXML
    private TableView<TransactionRecord> transactionTable;
    @FXML
    private TableView<CrmEntity> crmTable;
    @FXML
    private Button saveButton;
    @FXML
    private Button executeButton;
    @FXML
    private TableView<ResultEntity> resultTable;

    public MainController(ExecutorService executorService, TableService tableService, FileHandler fileHandler,
                          ResultService resultService, WriterService writerService, FileChooser fileChooser) {
        this.executorService = executorService;
        this.tableService = tableService;
        this.fileHandler = fileHandler;
        this.resultService = resultService;
        this.writerService = writerService;
        this.fileChooser = fileChooser;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableService.tuneTable(transactionTable, TransactionRecord.class);
        tableService.tuneTable(crmTable, CrmEntity.class);
        tableService.tuneTable(resultTable, ResultEntity.class);
    }

    @PreDestroy
    public void preDestroy() {
        executorService.shutdown();
    }

    public void chooseTransactionFile(ActionEvent actionEvent) {
        handleFile(transactionPathLabel, transactionTable, transactionProgressIndicator, TransactionRecord.class);

    }

    public void chooseCrmFile(ActionEvent actionEvent) {
        handleFile(crmPathLabel, crmTable, crmProgressIndicator, CrmEntity.class);
    }

    public void execute(ActionEvent actionEvent) {
        ObservableList<TransactionRecord> transactionRecords = transactionTable.getItems();
        ObservableList<CrmEntity> crmEntities = crmTable.getItems();
        if (transactionRecords.isEmpty() || crmEntities.isEmpty()) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("No file");
            errorAlert.setContentText("Both files have to be chosen");
            errorAlert.showAndWait();
            return;
        }
        List<ResultEntity> resultList = resultService.getResult(transactionRecords, crmEntities);
        resultTable.setItems(FXCollections.observableList(resultList));
        resultTable.setPrefHeight(300.0);
        resultTable.setPrefWidth(1075.0);
        resultTable.setVisible(true);
    }

    public void saveReport(ActionEvent actionEvent) {

    }

    private <T> void handleFile(Label label, TableView<T> table, ProgressIndicator progressIndicator, Class<T> clazz) {
        File file = getFile(label);
        if (file != null) {
            Runnable runnable = () -> {
                System.out.println("Thread " + Thread.currentThread().getName() + " started");
                performFetchingDataAndSettingTable(table, progressIndicator, clazz, file);
            };

            executorService.submit(runnable);
        }
    }

    private synchronized <T> void performFetchingDataAndSettingTable(TableView<T> table,
                                                                     ProgressIndicator progressIndicator,
                                                                     Class<T> clazz, File file) {
        progressIndicator.setVisible(true);
        List<T> entities = fileHandler.getEntitiesFromFile(file, clazz);
        table.setItems(FXCollections.observableList(entities));
        progressIndicator.setVisible(false);
    }

    private File getFile(Label pathLabel) {
        Window window = pathLabel.getScene().getWindow();
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
            pathLabel.setText(file.getAbsolutePath());
        }
        return file;
    }
}
