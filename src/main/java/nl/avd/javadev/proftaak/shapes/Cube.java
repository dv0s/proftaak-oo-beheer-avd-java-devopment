package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.ArrayList;
import java.util.List;

public class Cube extends Shape implements Calculable {

    private double edgeLength;

    public Cube(double edgeLength) {
        super();
        this.type = ShapeType.CUBE;
        this.edgeLength = edgeLength;
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
        return (edgeLength * edgeLength * edgeLength);
    }
}
