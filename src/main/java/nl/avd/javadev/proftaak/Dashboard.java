package nl.avd.javadev.proftaak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import nl.avd.javadev.proftaak.shapes.*;

public class Dashboard implements Initializable {

    @FXML
    private ComboBox<String> shapesDropdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(ShapeType.values());
        this.initShapesDropdown();
    }

    private void initShapesDropdown() {
        shapesDropdown.getItems().setAll(ShapeType.getShapeNameObject());
        shapesDropdown.getSelectionModel().selectedItemProperty().addListener((selected, oldValue, newValue) -> {
            try {
                handleShapeOptionsChange(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void handleShapeOptionsChange(String newShape) throws IOException {
        Shape shape = null;

        if (newShape.equals(ShapeType.CONE.toString())) {
            shape = new Cone();
        } else if (newShape.equals(ShapeType.CUBE.toString())) {
            shape = new Cube();
        } else if (newShape.equals(ShapeType.CYLINDER.toString())) {
            shape = new Cylinder();
        } else if (newShape.equals(ShapeType.PRISM.toString())) {
            shape = new Prism();
        } else if (newShape.equals(ShapeType.PYRAMID.toString())) {
            shape = new Pyramid();
        } else if (newShape.equals(ShapeType.SPHERE.toString())) {
            shape = new Sphere();
        }
        if (shape != null) {
            shape.openScene();
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
