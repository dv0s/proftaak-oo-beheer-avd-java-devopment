package nl.avd.javadev.proftaak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class Dashboard implements Initializable {

    private String[] shapes = {"Cone", "Cube", "Cylinder", "Prism", "Pyramid", "Sphere"};

    @FXML
    private ComboBox<String> shapeOptions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initShapeOptionsDropdown();
    }

    private void initShapeOptionsDropdown() {
        shapeOptions.getItems().setAll(this.shapes);
        shapeOptions.getSelectionModel().selectedItemProperty().addListener((selected, oldValue, newValue) -> {
            try {
                handleShapeOptionsChange(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void handleShapeOptionsChange(String newValue) throws IOException {
        if (newValue.equals("Cone")) {
            App.setRoot("shapes/cone");
        } else if (newValue.equals("Cube")) {
            App.setRoot("shapes/cube");
        } else if (newValue.equals("Cylinder")) {
            App.setRoot("shapes/cylinder");
        } else if (newValue.equals("Prism")) {
            App.setRoot("shapes/prism");
        } else if (newValue.equals("Pyramid")) {
            App.setRoot("shapes/pyramid");
        } else if (newValue.equals("Sphere")) {
            App.setRoot("shapes/sphere");
        }
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
