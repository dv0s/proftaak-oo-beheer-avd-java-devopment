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
    public double getVolume() {
        return 0.0;
    }

    public double calculateVolume() {
        int radius = 1;
        int height = 1;
        double pie = 3.14285714286;
        double volume = pie * (radius * radius) * height;

        throw new UnsupportedOperationException();
    }
}
