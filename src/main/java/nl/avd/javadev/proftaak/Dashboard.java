package nl.avd.javadev.proftaak;

import java.util.*;

public class Dashboard {

    private Shapes shapes = new Shapes();
    private ShapeDatabase shapeDatabase = new ShapeDatabase();

    public Dashboard() {
        this.shapes.addShapes(this.shapeDatabase.getAll());
    }

    public ArrayList<Shape> getShapes() {
        return this.shapes.getShapes();
    }

    public ArrayList<String> getShapeOptions() {
        ArrayList<String> options = new ArrayList<>();
        for (ShapeType value : ShapeType.values()) {
            options.add(value.toString());
        }
        return options;
    }

    public void createNewShape(String newShapeType) {
        HashMap<String, Object> shapeData = new HashMap<>();
        shapeData.put("type", newShapeType);
        Shape shape = this.shapes.addShape(shapeData);
        shape.showStage();
        if (shape.getProperties().size() > 0) {
            shape.setId(this.shapeDatabase.save(shape));
            return shape;
        }
        return null;
    }

    public void deleteShapes(List<Integer> selectedShapes) {
        if (selectedShapes.size() != 0) {
            for (int i = selectedShapes.size() - 1; i >= 0; i--) { // reverse loop to make sure shapes class removes shapes in correct order
                this.shapes.removeShape(selectedShapes.get(i));
            }
        }
    }

}
