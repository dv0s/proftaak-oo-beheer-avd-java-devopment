package nl.avd.javadev.proftaak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class Dashboard implements Initializable {

    @FXML
    private ComboBox<String> shapesDropdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initShapesDropdown();
    }

    private void initShapesDropdown() {
        System.out.println(ShapeType.shapeNames);
        shapesDropdown.getItems().setAll(ShapeType.shapeNames);
        shapesDropdown.getSelectionModel().selectedItemProperty().addListener((selected, oldValue, newValue) -> {
            try {
                handleShapeOptionsChange(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void handleShapeOptionsChange(String newValue) throws IOException {
        for (String shapeName : ShapeType.shapeNames) {
            if (shapeName.equals(newValue)) {
                App.setRoot("shapes/" + shapeName);
            }
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
