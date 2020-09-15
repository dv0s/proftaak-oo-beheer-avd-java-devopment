package shapes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    String[] shapes = {"Cube", "Cylinder", "Sphere", "Cone"};

    @FXML
    private ComboBox<String> shapeOptions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initShapeOptions();
    }

    private void initShapeOptions() {
        shapeOptions.getItems().setAll(this.shapes);
        shapeOptions.getSelectionModel().selectedItemProperty().addListener((selected, oldValue, newValue) -> handleShapeChange(newValue));
    }

    private void handleShapeChange(String newValue) {
        System.out.println(newValue);
    }
}
