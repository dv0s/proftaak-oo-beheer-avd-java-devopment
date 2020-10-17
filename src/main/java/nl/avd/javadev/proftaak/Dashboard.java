package nl.avd.javadev.proftaak;

import java.util.ArrayList;
import nl.avd.javadev.proftaak.shapes.*;

public class Dashboard {

    public Shapes shapes = new Shapes();

    public ArrayList<String> getShapeOptions() {
        ArrayList<String> options = new ArrayList<>();
        for (ShapeType value : ShapeType.values()) {
            options.add(value.toString());
        }
        return options;
    }

    public Shape createNewShape(String newShape) {
        Shape shape = null;
        if (newShape.equals(ShapeType.BLOCK.toString())) {
            shape = new Block(null);
        }else if (newShape.equals(ShapeType.CONE.toString())) {
            shape = new Cone(null);
        } else if (newShape.equals(ShapeType.CUBE.toString())) {
            shape = new Cube(null);
        } else if (newShape.equals(ShapeType.CYLINDER.toString())) {
            shape = new Cylinder(null);
        } else if (newShape.equals(ShapeType.PRISM.toString())) {
            shape = new Prism(null);
        } else if (newShape.equals(ShapeType.PYRAMID.toString())) {
            shape = new Pyramid(null);
        } else if (newShape.equals(ShapeType.SPHERE.toString())) {
            shape = new Sphere(null);
        }
        if (shape != null && shape.getProperties().size() > 0) {
            this.shapes.addShape(shape);
            this.shapes.printShapes();
        }
        return shape;
    }

}
