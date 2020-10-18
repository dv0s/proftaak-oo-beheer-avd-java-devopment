package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.ArrayList;
import java.util.List;

public class Cylinder extends Shape implements Calculable {

    private double radius;
    private double height;

    public Cylinder() {
        this(0,0);
    }

    public Cylinder(double radius, double height) {
        super();
        this.type = ShapeType.CYLINDER;
        this.radius = radius;
        this.height = height;
    }

    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("radius");
        fields.add("height");
        return fields;
    }

    @Override
    public double getVolume() {
        // TODO: Or get the value from the database
        return this.calculateVolume();
    }

    public double calculateVolume() {
        return  Math.PI * (radius * radius) * height;
    }
}
