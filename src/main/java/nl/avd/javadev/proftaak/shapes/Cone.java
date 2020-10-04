package nl.avd.javadev.proftaak.shapes;

import javafx.scene.control.TextField;
import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.iShape;

import java.util.HashMap;
import java.util.Map;

public class Cone extends Shape implements iShape {

    public Cone(Map<String, String> properties) {
        super();
        this.type = ShapeType.CONE;
        this.fields = new String[]{"radius", "height"};
        this.setProperties(properties);
    }

    @Override
    public void getVolume() {

    }

    @Override
    public void calculateVolume() {

    }
}
