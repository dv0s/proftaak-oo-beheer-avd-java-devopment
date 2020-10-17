package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Cone extends Shape implements Calculable {

    public Cone(Map<String, String> properties) {
        super();
        this.type = ShapeType.CONE;
        this.fields = new String[]{"radius", "height"};
        this.setProperties(properties);
    }

    @Override
    public double getVolume() {
        return (1.0/3) * Math.PI  * this.getProperty("radius") * this.getProperty("radius") * this.getProperty("height");
    }

    public double calculateVolume() {
        int radius = 1;
        int height = 1;
        double pie = 3.14285714286;
        double volume = pie * (radius * radius) * (height / 3.0);
//        return volume;
        throw new UnsupportedOperationException();
    }
}
