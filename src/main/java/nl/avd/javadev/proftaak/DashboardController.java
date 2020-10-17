package nl.avd.javadev.proftaak;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class DashboardController implements Initializable {

    @FXML public ComboBox<String> shapesDropdown;
    @FXML public ListView shapesListView;
    private Dashboard dashboard = new Dashboard();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fillShapesDropdown();
        this.updateShapesList();
    }

    private void fillShapesDropdown() {
        System.out.println(this.dashboard);
        this.shapesDropdown.getItems().setAll(this.dashboard.getShapeOptions());
        this.shapesDropdown.setPromptText("Choose a shape");
        this.shapesDropdown.getSelectionModel().selectedItemProperty().addListener(
            (selected, oldValue, newValue) -> {
                if (newValue != null) {
                    this.dashboard.createNewShape(newValue);
                    this.updateShapesList();
//                    this.shapesDropdown.getSelectionModel().clearSelection();
                }
            }
        );
    }

    private void updateShapesList() {
        this.shapesListView.getItems().clear();
        this.dashboard.shapes.getShapes().forEach((shape) -> {
            this.shapesListView.getItems().add(shape.toString());
        });
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
