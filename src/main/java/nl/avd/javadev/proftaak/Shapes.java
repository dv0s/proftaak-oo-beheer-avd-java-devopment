package nl.avd.javadev.proftaak;

import java.util.ArrayList;

public class Shapes {

    private ArrayList<Shape> shapes;

    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void saveShape(Shape shape) {
        System.out.println("Save shape to database");
    }

    public void removeShape(int shapeIndex) {
        if (shapeIndex < this.shapes.size()) { // item exisits
            this.shapes.remove(shapeIndex);
        }
    }

    public void printShapes() {
        System.out.println("Print all shapes");
    }

}
