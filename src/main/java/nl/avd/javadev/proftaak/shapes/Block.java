package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Calculable;
import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;

import java.util.ArrayList;
import java.util.List;

public class Block extends Shape implements Calculable {

    private double length;
    private double width;
    private double height;

    public Block() {
        this(0,0,0);
    }

    public Block(double length, double width, double height) {
        super();
        this.type = ShapeType.SPHERE;
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
        // TODO: or get the volume from the db
        return this.calculateVolume();
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
