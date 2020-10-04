package nl.avd.javadev.proftaak;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import nl.avd.javadev.proftaak.shapes.*;

public class Dashboard implements Initializable {

    @FXML public ComboBox<String> shapesDropdown;
    @FXML public ListView shapesListView;
    private Shapes shapes;

    public Dashboard() {
        this.shapes = new Shapes();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initShapesDropdown();
        this.fillShapesListView();
    }

    private void initShapesDropdown() {
        this.shapesDropdown.getItems().setAll(ShapeType.getShapeNameObject());
        this.shapesDropdown.setPromptText("Choose a shape");
        this.shapesDropdown.getSelectionModel().selectedItemProperty().addListener(
            (selected, oldValue, newValue) -> {
                try {
                    if (newValue != null) {
                        this.handleShapeOptionsChange(newValue);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        );
    }

    private void fillShapesListView() {
        this.shapesListView.getItems().clear();
        this.shapes.getShapes().forEach((shape) -> {
            this.shapesListView.getItems().add(shape.toString());
        });
    }

    private void handleShapeOptionsChange(String newShape) throws IOException {
        System.out.println(newShape);
        Shape shape = null;
        if (newShape.equals(ShapeType.CONE.toString())) {
            shape = new Cone(null);
        } else if (newShape.equals(ShapeType.CUBE.toString())) {
            shape = new Cube(null);
        } else if (newShape.equals(ShapeType.CYLINDER.toString())) {
            shape = new Cylinder(null);
        } else if (newShape.equals(ShapeType.PRISM.toString())) {
            shape = new Prism(null);
        } else if (newShape.equals(ShapeType.PYRAMID.toString())) {
            shape = new Pyramid(null);
        } else if (newShape.equals(ShapeType.SPHERE.toString())) {
            shape = new Sphere(null);
        }
        if (shape != null && shape.getProperties().size() > 0) {
            System.out.println(shape.getProperties());
            this.shapes.addShape(shape);
            this.shapes.printShapes();
            this.fillShapesListView();
        }
//        this.shapesDropdown.getSelectionModel().clearSelection();
//        this.shapesDropdown.setValue(null);
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
