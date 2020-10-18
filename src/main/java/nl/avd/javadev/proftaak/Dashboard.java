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
            shape = new Block();
        }else if (newShape.equals(ShapeType.CONE.toString())) {
            shape = new Cone();
        } else if (newShape.equals(ShapeType.CUBE.toString())) {
            shape = new Cube();
        } else if (newShape.equals(ShapeType.CYLINDER.toString())) {
            shape = new Cylinder();
        } else if (newShape.equals(ShapeType.PRISM.toString())) {
            shape = new Prism();
        } else if (newShape.equals(ShapeType.PYRAMID.toString())) {
            shape = new Pyramid();
        } else if (newShape.equals(ShapeType.SPHERE.toString())) {
            shape = new Sphere();
        }
        if (shape != null && shape.getFields().size() > 0) {
            this.shapes.addShape(shape);
            this.shapes.printShapes();
        }
        return shape;
    }

}
