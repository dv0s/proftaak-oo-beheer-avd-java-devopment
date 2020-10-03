package nl.avd.javadev.proftaak.shapes;

import java.net.URL;
import java.util.ResourceBundle;
import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.iShape;

public class Cube extends Shape implements iShape {

    public Cube() {
        this.shapeType = ShapeType.CUBE;
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
