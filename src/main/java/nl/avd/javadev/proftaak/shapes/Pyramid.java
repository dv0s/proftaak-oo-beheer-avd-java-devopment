package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pyramid extends Shape implements Calculable {

    private double length;
    private double width;
    double height;


    public Pyramid() {
        this(0,0,0);
    }

    public Pyramid(double length, double width, double height) {
        super();
        this.type = ShapeType.PYRAMID;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("length");
        fields.add("width");
        fields.add("height");
        return fields;
    }

    @Override
    public double getVolume() {
        // TODO: Or get the volume from the database
        return this.calculateVolume();
    }

    public double calculateVolume() {
        return (1.0 / 3.0) * (this.getProperty("length") * this.getProperty("width")) * this.getProperty("height");
    }
}
