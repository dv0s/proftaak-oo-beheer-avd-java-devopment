package nl.avd.javadev.proftaak;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class DashboardController implements Initializable {

    @FXML private ComboBox<String> shapesDropdown;
    @FXML private ListView<String> shapesListView;
    @FXML private TextField calcVolSelectedShapes;
    @FXML private TextField calcVolAllShapes;
    private final Dashboard dashboard;

    public DashboardController() {
        this.dashboard = new Dashboard();
    }

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
                        Double currentTotal = Double.parseDouble(this.calcVolAllShapes.getText());
                        this.calcVolAllShapes.setText(String.valueOf(currentTotal + shape.getVolume()));
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
        this.calculateVolumeAllShapes();
    }

    private void calculateVolumeAllShapes() {
        double total = this.dashboard.getShapes().stream().mapToDouble(Shape::getVolume).sum();
        this.calcVolAllShapes.setText(String.valueOf(total));
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
        this.calculateVolumeAllShapes();
    }

    @FXML private  void exportObjectAction(){
        this.dashboard.exportShapesToObject();
    }

    @FXML
    private void importObjectAction(){
        List<Shape> shapes = this.dashboard.importShapesFromObject();
        for (Shape shape: shapes){
            this.shapesListView.getItems().add(shape.toString());
        }
        this.calculateVolumeAllShapes();
    }

    @FXML
    private void calculateVolumeSelectedShapes() {
        Double total = 0.0;
        List<Integer> selectedItems = this.shapesListView.getSelectionModel().getSelectedIndices();
        for (Integer selectedItem : selectedItems) {
            total += this.dashboard.getShape(selectedItem).getVolume();
        }
        this.calcVolSelectedShapes.setText(String.valueOf(total));
    }

    @FXML
    private void deleteSelectedShapes() {
        List<Integer> selectedItems = this.shapesListView.getSelectionModel().getSelectedIndices();
        this.dashboard.deleteShapes(selectedItems);
        for (int i = selectedItems.size() - 1; i >= 0; i--) {
            this.shapesListView.getItems().remove((int) selectedItems.get(i));
        }
        this.shapesListView.getSelectionModel().clearSelection();
        this.calculateVolumeAllShapes();
    }

}
