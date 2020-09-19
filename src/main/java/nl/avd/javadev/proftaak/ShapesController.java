package nl.avd.javadev.proftaak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ShapesController implements Initializable {

    private String[] shapes = {"Cube", "Cylinder", "Sphere", "Cone", "Pyramid", "Prism"};

    @FXML
    private ComboBox<String> shapeOptions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initShapeOptionsDropdown();
    }

    private void initShapeOptionsDropdown() {
        shapeOptions.getItems().setAll(this.shapes);
        shapeOptions.getSelectionModel().selectedItemProperty().addListener((selected, oldValue, newValue) -> handleShapeOptionsChange(newValue));
    }

    private void handleShapeOptionsChange(String newValue) {
        System.out.println(newValue);
    }

    @FXML
    private void saveToDatabase(ActionEvent event) {
        System.out.println("TODO: Save input to database");
    }

    @FXML
    private void loadFromTextFile(ActionEvent event) {
        System.out.println("TODO: Load data from text file");
    }

    @FXML
    private void calculateTotalContents(ActionEvent event) {
        System.out.println("TODO: Calculate total contents of all shapes combined");
    }

    @FXML
    private void deleteSelectedShape(ActionEvent event) {
        System.out.println("TODO: Delete selected shape");
    }

}
