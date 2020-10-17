package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Sphere  extends Shape implements Calculable {

    public Sphere(Map<String, String> properties) {
        super();
        this.type = ShapeType.SPHERE;
        this.fields = new String[]{"radius"};
        this.setProperties(properties);
    }

    @Override
    public void getVolume() {

    }

    @Override
    public double calculateVolume() {
        int radius = 1;
        double pie=3.14285714286;
        double volume=(4.0/3.0)*pie*(radius*radius*radius);
        return volume;
    }
}
