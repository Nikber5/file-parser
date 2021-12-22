package com.example.fileparser.javaFX.controller;

import com.example.fileparser.model.CrmEntity;
import com.example.fileparser.model.TransactionRecord;
import com.example.fileparser.service.TableService;
import com.example.fileparser.service.WriterService;
import com.example.fileparser.service.handler.FileHandler;
import com.example.fileparser.service.strategy.FileStrategy;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-stage.fxml")
public class MainController implements Initializable {
    private final TableService tableService;
    private final FileHandler fileHandler;
    private final WriterService writerService;
    private final FileChooser fileChooser;

    @FXML
    private VBox vBox;
    @FXML
    private Label transactionPathLabel;
    @FXML
    private Button transactionFileChooserButton;
    @FXML
    private Label crmPathLabel;
    @FXML
    private Button crmFileChooserButton;
    @FXML
    private TableView<TransactionRecord> transactionTable;
    @FXML
    private TableView<CrmEntity> crmTable;
    @FXML
    private Button saveButton;
    @FXML
    private Button executeButton;
    @FXML
    private TableView resultTable;

    public MainController(TableService tableService, FileHandler fileHandler,
                          WriterService writerService, FileChooser fileChooser) {
        this.tableService = tableService;
        this.fileHandler = fileHandler;
        this.writerService = writerService;
        this.fileChooser = fileChooser;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableService.tuneTransactionRecordTable(transactionTable);
        tableService.tuneCrmEntityTable(crmTable);
    }

    public void chooseTransactionFile(ActionEvent actionEvent) {
        handleFile(transactionPathLabel, transactionTable, TransactionRecord.class);

    }

    public void chooseCrmFile(ActionEvent actionEvent) {
        handleFile(crmPathLabel, crmTable, CrmEntity.class);
    }

    public void saveReport(ActionEvent actionEvent) {

    }

    public void execute(ActionEvent actionEvent) {

    }

    private <T> void handleFile(Label label, TableView<T> table, Class<T> clazz) {
        File file = getFile(label);
        List<T> entities = fileHandler.getEntitiesFromFile(file, clazz);
        populateTable(table, FXCollections.observableList(entities));
    }

    private File getFile(Label pathLabel) {
        Window window = getWindow();
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
            pathLabel.setText(file.getAbsolutePath());
            return file;
        } else {
            throw new RuntimeException("No such file");
        }
    }

    private Window getWindow() {
        return vBox.getScene().getWindow();
    }

    private <T> void populateTable(TableView<T> table, ObservableList<T> entities) {
        table.setItems(entities);
    }
}
