package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.ArrayList;
import java.util.List;

public class Prism extends Shape implements Calculable {

    private double triangleBase;
    private double triangleHeight;
    private double prismHeight;

    public Prism(double triangleBase, double triangleHeight, double prismHeight) {
        super();
        this.type = ShapeType.PRISM;
        this.triangleBase = triangleBase;
        this.triangleHeight = triangleHeight;
        this.prismHeight = prismHeight;
    }

    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("triangleBase");
        fields.add("triangleHeight");
        fields.add("prismHeight");
        return fields;
    }

    @Override
    public double getVolume() {
        // TODO: Or get the volume from the Database
        return this.calculateVolume();
    }

    public double calculateVolume() {
        return ((0.5) * (triangleBase * triangleHeight) * prismHeight);
    }
}
