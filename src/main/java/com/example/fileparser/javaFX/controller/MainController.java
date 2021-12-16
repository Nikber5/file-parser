package com.example.fileparser.javaFX.controller;

import com.example.fileparser.mapper.EntityMapper;
import com.example.fileparser.model.Entity;
import com.example.fileparser.service.ReaderService;
import com.example.fileparser.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-stage.fxml")
public class MainController {
    private static final String FILE_SUFFIX = ".csv";
    private static final String REPORT_FILENAME = "report";
    private final ReaderService readerService;
    private final WriterService writerService;
    private final EntityMapper entityMapper;
    private final FileChooser fileChooser;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label firstPathLabel;
    @FXML
    private Button firstFileChooserButton;
    @FXML
    private Label secondPathLabel;
    @FXML
    private Button secondFileChooserButton;
    @FXML
    private TextArea firstTextArea;
    @FXML
    private TextArea secondTextArea;
    @FXML
    private Button saveButton;
    @FXML
    private TableView<Entity> table;

    public MainController(ReaderService readerService, WriterService writerService,
                          EntityMapper entityMapper, FileChooser fileChooser) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.entityMapper = entityMapper;
        this.fileChooser = fileChooser;
    }

    public void chooseFirstFile(ActionEvent actionEvent) {
        handleFile(firstPathLabel, firstTextArea);
    }

    public void chooseSecondFile(ActionEvent actionEvent) {
        handleFile(secondPathLabel, secondTextArea);
    }

    public void saveReport(ActionEvent actionEvent) {
        String firstText = firstTextArea.getText();
        String secondText = secondTextArea.getText();
        if (firstText == null || firstText.equals("") || secondText == null || secondText.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Both files have to be defined");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    System.out.println("Button was pressed");
                }
            });
            return;
        }
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(getWindow());

        String filename = REPORT_FILENAME;
        boolean fileCreated = false;
        int number = 1;
        Path path;
        while (!fileCreated) {
            try {
                File file = new File(directory, filename + FILE_SUFFIX);
                path = Files.createFile(file.toPath());
                fileCreated = true;
                writerService.writeToFile(path, List.of(firstText, secondText));
            } catch (FileAlreadyExistsException e) {
                System.out.println("File already exists");
                if (filename.equals(REPORT_FILENAME)) {
                    filename = filename + "(" + number + ")";
                } else {
                    String[] split = filename.split("\\(");
                    filename = split[0] + "(" + number + ")";
                }
                number++;
            } catch (IOException e) {
                throw new RuntimeException("Can't create a file", e);
            }
        }
    }

    private void handleFile(Label pathLabel, TextArea textArea) {
        Window window = getWindow();
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            List<String> lines = readerService.readSmallFile(file);
            List<Entity> entities = lines.stream()
                    .map(entityMapper::mapToModel)
                    .collect(Collectors.toList());
            List<String> result = entityMapper.toStrings(entities);
            pathLabel.setText(file.getAbsolutePath());
            textArea.setText(String.join("", result));

            getTable(FXCollections.observableList(entities));
        }
    }

    private Window getWindow() {
        return anchorPane.getScene().getWindow();
    }

    private void getTable(ObservableList<Entity> entities) {
        TableColumn<Entity, String> firstColumn = new TableColumn<>("First value");
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("first"));
        table.getColumns().add(firstColumn);

        TableColumn<Entity, String> secondColumn = new TableColumn<>("Second value");
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("second"));
        table.getColumns().add(secondColumn);

        TableColumn<Entity, String> thirdColumn = new TableColumn<>("Third value");
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("third"));
        table.getColumns().add(thirdColumn);

        TableColumn<Entity, String> fourthColumn = new TableColumn<>("Fourth value");
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("fourth"));
        table.getColumns().add(fourthColumn);

        TableColumn<Entity, String> fifthColumn = new TableColumn<>("Fifth value");
        fifthColumn.setCellValueFactory(new PropertyValueFactory<>("fifth"));
        table.getColumns().add(fifthColumn);

        table.setItems(entities);
        table.setVisible(true);

    }
}
