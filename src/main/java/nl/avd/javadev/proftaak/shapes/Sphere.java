package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Sphere extends Shape implements Calculable {

    public Sphere(Map<String, String> properties) {
        super();
        this.type = ShapeType.SPHERE;
        this.fields = new String[]{"radius"};
        this.setProperties(properties);
    }

    @Override
    public double getVolume() {
        return this.getProperty("volume");
    }

    public void calculateVolume() {
        double volume = (4.0 / 3.0) * Math.PI * (this.getProperty("radius") * this.getProperty("radius") * this.getProperty("radius"));
        this.setProperty("volume", "" + volume);
    }
}
