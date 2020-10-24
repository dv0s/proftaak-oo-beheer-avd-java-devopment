package nl.avd.javadev.proftaak;

import nl.avd.javadev.proftaak.shapes.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shapes implements Serializable {

    private final ArrayList<Shape> shapes;

    public Shapes() {
        this.shapes = new ArrayList<>();
    }

    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }

    public void addShapes(List<HashMap<String, Object>> shapes) {
        for (HashMap<String, Object> shape : shapes) {
            this.addShape(shape);
        }
    }

    public Shape addShape(HashMap<String, Object> shapeData) {
        String shapeType = (String) shapeData.get("type");
        Integer id = shapeData.containsKey("id") ? (Integer) shapeData.get("id") : null;
        Shape shape = null;

        if (shapeType.equals(ShapeType.CONE.toString())) {
            shape = new Cone(id);
        } else if (shapeType.equals(ShapeType.CUBE.toString())) {
            shape = new Cube(id);
        } else if (shapeType.equals(ShapeType.CYLINDER.toString())) {
            shape = new Cylinder(id);
        } else if (shapeType.equals(ShapeType.PRISM.toString())) {
            shape = new Prism(id);
        } else if (shapeType.equals(ShapeType.PYRAMID.toString())) {
            shape = new Pyramid(id);
        } else if (shapeType.equals(ShapeType.SPHERE.toString())) {
            shape = new Sphere(id);
        }
        if (shape != null) {
            this.shapes.add(shape);
        }
        return shape;
    }

    public Shape getByIndex(Integer index) {
        return this.shapes.get(index);
    }

    public void removeShape(int shapeIndex) {
        ShapeDatabase shapeDatabase = new ShapeDatabase();
        Shape shape = this.getByIndex(shapeIndex);
        shapeDatabase.delete(shape);
        this.shapes.remove(shapeIndex);
    }
}
