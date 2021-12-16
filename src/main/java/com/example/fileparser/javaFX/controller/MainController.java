package com.example.fileparser.javaFX.controller;

import com.example.fileparser.mapper.EntityMapper;
import com.example.fileparser.model.Entity;
import com.example.fileparser.service.ReaderService;
import com.example.fileparser.service.WriterService;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-stage.fxml")
public class MainController implements Initializable {
    private final ReaderService readerService;
    private final WriterService writerService;
    private final EntityMapper entityMapper;
    private final FileChooser fileChooser;

    @FXML
    private VBox vBox;
    @FXML
    private Label firstPathLabel;
    @FXML
    private Button firstFileChooserButton;
    @FXML
    private Label secondPathLabel;
    @FXML
    private Button secondFileChooserButton;
    @FXML
    private TableView<Entity> firstTableView;
    @FXML
    private TableView<Entity> secondTableView;
    @FXML
    private Button saveButton;
    @FXML
    private Button executeButton;
    @FXML
    private TableView<Entity> table;

    public MainController(ReaderService readerService, WriterService writerService,
                          EntityMapper entityMapper, FileChooser fileChooser) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.entityMapper = entityMapper;
        this.fileChooser = fileChooser;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tuneEntityTable(table);
        tuneEntityTable(firstTableView);
        tuneEntityTable(secondTableView);
    }

    public void chooseFirstFile(ActionEvent actionEvent) {
        handleFile(firstPathLabel, firstTableView);
    }

    public void chooseSecondFile(ActionEvent actionEvent) {
        handleFile(secondPathLabel, secondTableView);
    }

    public void saveReport(ActionEvent actionEvent) {
        ObservableList<Entity> firstItems = firstTableView.getItems();
        ObservableList<Entity> secondItems = secondTableView.getItems();
        if (firstItems == null || firstItems.isEmpty() || secondItems == null || secondItems.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Both files have to be defined");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    System.out.println("Button was pressed");
                }
            });
            return;
        }

        File file = fileChooser.showSaveDialog(getWindow());
        if (file != null) {
            saveTextToFile("Saved content", file);
        }
    }

    public void execute(ActionEvent actionEvent) {
        ObservableList<Entity> firstItems = firstTableView.getItems();
        ObservableList<Entity> secondItems = secondTableView.getItems();
        table.setItems(firstItems);
        table.getItems().addAll(secondItems);
        saveButton.setVisible(true);
        table.setVisible(true);
    }

    private void saveTextToFile(String savedContent, File file) {
        writerService.writeToFile(file.toPath(), List.of(savedContent));
    }

    private void handleFile(Label pathLabel, TableView<Entity> table) {
        Window window = getWindow();
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
            List<String> lines = readerService.readSmallFile(file);
            List<Entity> entities = lines.stream()
                    .map(entityMapper::mapToModel)
                    .collect(Collectors.toList());
            pathLabel.setText(file.getAbsolutePath());

            populateTable(table, FXCollections.observableList(entities));
        }
    }

    private Window getWindow() {
        return vBox.getScene().getWindow();
    }

    private void populateTable(TableView<Entity> table, ObservableList<Entity> entities) {
        table.setItems(entities);
    }

    private void tuneEntityTable(TableView<Entity> tableView) {
        TableColumn<Entity, String> firstColumn = new TableColumn<>("First value");
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("first"));
        tableView.getColumns().add(firstColumn);

        TableColumn<Entity, String> secondColumn = new TableColumn<>("Second value");
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("second"));
        tableView.getColumns().add(secondColumn);

        TableColumn<Entity, String> thirdColumn = new TableColumn<>("Third value");
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("third"));
        tableView.getColumns().add(thirdColumn);

        TableColumn<Entity, String> fourthColumn = new TableColumn<>("Fourth value");
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("fourth"));
        tableView.getColumns().add(fourthColumn);

        TableColumn<Entity, String> fifthColumn = new TableColumn<>("Fifth value");
        fifthColumn.setCellValueFactory(new PropertyValueFactory<>("fifth"));
        tableView.getColumns().add(fifthColumn);
    }
}
