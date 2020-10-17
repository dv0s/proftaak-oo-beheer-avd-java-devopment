package nl.avd.javadev.proftaak;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard {

    public Shapes shapes = new Shapes();
    private ShapeDatabase shapeDatabase = new ShapeDatabase();

    public Dashboard() {
        this.shapes.addShapes(this.shapeDatabase.getAll());
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
        this.shapeDatabase.save(shape);
    }

}
