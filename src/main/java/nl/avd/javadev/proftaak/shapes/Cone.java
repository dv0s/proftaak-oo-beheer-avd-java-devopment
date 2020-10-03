package nl.avd.javadev.proftaak.shapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.iShape;

import java.io.IOException;

public class Cone extends Shape implements iShape {

    @FXML private TextField radiusField;
    @FXML private TextField heightField;
    private int radius;
    private int height;

    public Cone() {
        super(ShapeType.CONE);
    }

    @Override
    public void getType() {

    }

    @Override
    public void getVolume() {

    }

    @Override
    public void calculateVolume() {

    }

    @FXML
    private void saveShape(ActionEvent event) throws IOException {
        if (!this.radiusField.getText().equals("")) {
            this.radius = Integer.parseInt(this.radiusField.getText());
        }
        if (!this.heightField.getText().equals("")) {
            this.height = Integer.parseInt(this.heightField.getText());
        }
        System.out.println("TODO: Save input to database");
        this.closeWindow(event);
    }

    @Override
    public String toString() {
        return "Cone{" +
                "radius=" + radius +
                ", height=" + height +
                '}';
    }
}
