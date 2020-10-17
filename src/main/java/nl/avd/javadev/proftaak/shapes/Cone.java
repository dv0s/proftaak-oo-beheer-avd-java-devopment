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

    @Override
    public void calculateVolume() {

    }
}
