package nl.avd.javadev.proftaak;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Shape {

    private ShapeDatabase shapeDatabase = new ShapeDatabase();
    protected Integer id = null;
    protected Double volume = null;
    protected ShapeType type;
    protected String[] fields;
    private Map<String, String> properties = new HashMap<>();

    public void getUserInput() {
        ShapeController shapeController = new ShapeController(this.type.toString(), this.fields);
        this.setProperties(shapeController.getShapeProperties());
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String toString() {
        String propertiesSting = this.getPropertySting();
        return this.type + " - " + propertiesSting;
    }

    public String getType() {
        return this.type.toString();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getProperty(String key) {
        return Double.parseDouble(this.properties.get(key));
    }

    protected void getDataFromDatabase() {
        HashMap<String, Object> shapeData = this.shapeDatabase.getShapeData(this.id);
        this.setProperties(this.propertyStringToMap((String) shapeData.get("properties")));
        this.volume = (Double) shapeData.get("volume");
    }

    private Map<String, String> propertyStringToMap(String propertyString) {
        Map<String, String> properties = new HashMap<>();
        String[] propertyPairs = propertyString.split(", ");
        for (int i = 0; i < propertyPairs.length; i++) {
            String property = propertyPairs[i];
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

    public void setProperties(Map<String,String> properties){
        this.properties = properties;
    }
}
