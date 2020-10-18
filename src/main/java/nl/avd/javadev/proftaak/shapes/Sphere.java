package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sphere extends Shape implements Calculable {

    private double radius;

    public Sphere() {
        this(0);
    }

    public Sphere(double radius) {
        super();
        this.type = ShapeType.SPHERE;
        this.radius = radius;
    }

    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("radius");
        return fields;
    }

    @Override
    public double getVolume() {
        // TODO: Or get volume from the database
        return this.getProperty("volume");
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * (this.getProperty("radius") * this.getProperty("radius") * this.getProperty("radius"));
    }
}
