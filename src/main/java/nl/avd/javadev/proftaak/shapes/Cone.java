package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.ArrayList;
import java.util.List;

public class Cone extends Shape implements Calculable {

    private double radius;
    private double height;

    public Cone(double radius, double height) {
        super();
        this.type = ShapeType.CONE;
        this.radius = radius;
        this.height = height;
    }

    @Override
    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("radius");
        fields.add("height");
        return fields;
    }

    @Override
    public double getVolume() {
        // TODO: or get the volume from the db
        return this.getProperty("volume");
    }

    @Override
    public double calculateVolume() {
        return Math.PI * ((this.radius * this.radius) * (this.height / 3.0));
    }
}
