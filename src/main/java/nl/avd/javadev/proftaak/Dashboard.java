package nl.avd.javadev.proftaak;

import java.util.*;

public class Dashboard {

    private final Shapes shapes;

    public Dashboard() {
        this.shapes = new Shapes();
        ShapeDatabase shapeDatabase = new ShapeDatabase();
        this.shapes.addShapes(shapeDatabase.getAll());
    }

    public ArrayList<Shape> getShapes() {
        return this.shapes.getShapes();
    }

    public Shape getShape(Integer index){
        return this.shapes.getByIndex(index);
    }

    public List<String> getShapeOptions() {
        List<String> options = new ArrayList<>();

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
            ShapeDatabase shapeDatabase = new ShapeDatabase();
            shape.setId(shapeDatabase.save(shape));
            shape.setVolume(((Calculable) shape).getVolume());

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
        ShapeDatabase shapeDatabase = new ShapeDatabase();
        FileService fileService = new FileService();
        List<Map<String, ?>> shapesData = fileService.getDataFromFile();
        List<Shape> appendedShapes = new ArrayList<>();

        for (Map<String, ?> shapeData : shapesData) {
            Shape newShape = this.shapes.addShape(new HashMap<>() {{
                put("type", shapeData.get("type"));
            }});
            System.out.println(shapeData.get("properties"));
            @SuppressWarnings("unchecked")
            Map<String, String> properties = (Map<String, String>) shapeData.get("properties");
            newShape.setProperties(properties);
            newShape.setId(shapeDatabase.save(newShape));
            newShape.setVolume(((Calculable) newShape).getVolume());
            appendedShapes.add(newShape);
        }

        return appendedShapes;
    }

}
