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

    public Shape getShape(int index){
        return this.shapes.getByIndex(index);
    }

    public ArrayList<String> getShapeOptions() {
        ArrayList<String> options = new ArrayList<>();
        for (ShapeType value : ShapeType.values()) {
            options.add(value.toString());
        }
        return options;
    }

    public Shape createNewShape(String newShapeType) {
        HashMap<String, Object> shapeData = new HashMap<>();
        shapeData.put("type", newShapeType);
        Shape shape = this.shapes.addShape(shapeData);
        shape.getUserInput();
        if (shape.getProperties().size() > 0) {
            shape.setId(this.shapeDatabase.save(shape));
            shape.volume = ((Calculable) shape).getVolume();
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

    public void exportShapes() {
        FileService fileService = new FileService();
        fileService.writeToFile(this.shapes.getShapes());
    }

    public List<Shape> importShapes() {
        FileService fileService = new FileService();
        List<Map> shapesData = fileService.getDataFromFile();
        List<Shape> appendedShapes = new ArrayList<>();

        for (Map shapeData : shapesData) {
            Shape newShape = this.shapes.addShape(new HashMap<>() {{
                put("type", shapeData.get("type"));
            }});
            newShape.setProperties((Map) shapeData.get("properties"));
            newShape.setId(this.shapeDatabase.save(newShape));
            appendedShapes.add(newShape);
        }

        return appendedShapes;
    }

}
