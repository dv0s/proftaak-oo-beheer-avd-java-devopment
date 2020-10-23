package nl.avd.javadev.proftaak;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Shape {

    private Integer id;
    private Double volume;
    private ShapeType type;
    private String[] fields;
    private Map<String, String> properties;

    public Shape() {
        this.id = null;
        this.volume = null;
        this.properties = new HashMap<>();
    }

    public void getUserInput() {
        ShapeController shapeController = new ShapeController(this.type.toString(), this.fields);
        this.setProperties(shapeController.getShapeProperties());
    }

    public String toString() {
        String propertiesSting = this.getPropertySting();
        return this.type + " - " + propertiesSting;
    }

    protected void getDataFromDatabase() {
        ShapeDatabase shapeDatabase = new ShapeDatabase();
        HashMap<String, Object> shapeData = shapeDatabase.getShapeData(this.id);
        this.setProperties(this.propertyStringToMap((String) shapeData.get("properties")));
        this.volume = (Double) shapeData.get("volume");
    }

    public Double getProperty(String key) {
        return Double.parseDouble(this.properties.get(key));
    }

    private Map<String, String> propertyStringToMap(String propertyString) {
        Map<String, String> properties = new HashMap<>();
        String[] propertyPairs = propertyString.split(", ");
        for (String property : propertyPairs) {
            String[] keyValue = property.split(": ");
            properties.put(keyValue[0], keyValue[1]);
        }
        return properties;
    }

    public String getPropertySting() {
        return this.properties.keySet().stream()
                .map(key -> key + ": " + this.properties.get(key))
                .collect(Collectors.joining(", ", "", ""));
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getVolume() {
        return this.volume;
    }

    public String getType() {
        return this.type.toString();
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String,String> properties){
        this.properties = properties;
    }
}
