package nl.avd.javadev.proftaak;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class DashboardController implements Initializable {

    @FXML public ComboBox<String> shapesDropdown;
    @FXML public ListView shapesListView;
    private Dashboard dashboard = new Dashboard();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fillShapesDropdown();
        this.initShapesList();
    }

    private void fillShapesDropdown() {
        this.shapesDropdown.getItems().setAll(this.dashboard.getShapeOptions());
        this.shapesDropdown.setPromptText("Choose a shape");
        this.shapesDropdown.getSelectionModel().selectedItemProperty().addListener(
            (selected, oldValue, newValue) -> {
                if (newValue != null) {
                    Shape shape = this.dashboard.createNewShape(newValue);
                    if (shape != null) {
                        this.shapesListView.getItems().add(shape.toString());
                    }
//                    this.shapesDropdown.getSelectionModel().clearSelection();
                }
            }
        );
    }

    private void initShapesList() {
        this.shapesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.shapesListView.getItems().clear();
        this.dashboard.getShapes().forEach((shape) -> this.shapesListView.getItems().add(shape.toString()));
    }

    @FXML
    private void exportAction() {
        this.dashboard.exportShapes();
    }

    @FXML
    private void importAction() {
        List<Shape> shapes = this.dashboard.importShapes();
        for (Shape shape : shapes) {
            this.shapesListView.getItems().add(shape.toString());
        }
    }

    @FXML
    private void calculateTotalContents(ActionEvent event) {
        System.out.println("TODO: Calculate total contents of all shapes combined");
    }

    @FXML
    private void deleteSelectedShapes(ActionEvent event) {
        List<Integer> selectedItems = this.shapesListView.getSelectionModel().getSelectedIndices();
        this.dashboard.deleteShapes(selectedItems);
        for (int i = selectedItems.size() - 1; i >= 0; i--) {
            this.shapesListView.getItems().remove((int) selectedItems.get(i));
        }
        this.shapesListView.getSelectionModel().clearSelection();
    }

}
