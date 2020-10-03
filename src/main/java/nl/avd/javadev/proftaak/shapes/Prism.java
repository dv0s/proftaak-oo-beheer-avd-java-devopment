package nl.avd.javadev.proftaak.shapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import nl.avd.javadev.proftaak.App;
import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.iShape;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Prism  extends Shape implements iShape {
    public Prism() {
        this.shapeType = ShapeType.PRISM;
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
}
