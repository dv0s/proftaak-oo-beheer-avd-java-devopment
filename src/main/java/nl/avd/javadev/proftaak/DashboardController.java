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
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class DashboardController implements Initializable {

    @FXML public ComboBox<String> shapesDropdown;
    @FXML public ListView shapesListView;
    @FXML public TextField calcVolSelectedShapes;
    @FXML public TextField calcVolAllShapes;
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
    private void calculateTotalVolumeSelectedShapes(ActionEvent event) {
        double total = 0.0;
        List<Integer> selectedItems = this.shapesListView.getSelectionModel().getSelectedIndices();
        for (int i = 0; i < selectedItems.size(); i++) {
            total += 1.0;
        }
        this.calcVolSelectedShapes.setText("" + total);
    }

    @FXML
    private void calculateTotalVolumeAllShapes(ActionEvent event) {
        double total = this.dashboard.getShapes().stream().mapToDouble(shape -> shape.volume).sum();
        this.calcVolAllShapes.setText("" + total);
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
