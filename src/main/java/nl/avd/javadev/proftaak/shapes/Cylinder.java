package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Cylinder extends Shape implements Calculable {

    public Cylinder(Map<String, String> properties) {
        super();
        this.type = ShapeType.CYLINDER;
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
