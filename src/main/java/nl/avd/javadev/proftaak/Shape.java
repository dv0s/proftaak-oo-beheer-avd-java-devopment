package nl.avd.javadev.proftaak;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Shape {

    private Stage window;
    private ShapeDatabase shapeDatabase;
    protected ShapeType type;
    protected Integer id;
    protected Double volume;
    protected String[] fields;
    private Map<String, String> properties;
    private Map<String, TextField> textFields;
    private Button saveButton;
    private Button cancelButton;

    public Shape(){
        this.shapeDatabase = new ShapeDatabase();
        this.id = null;
        this.volume = null;
        this.properties = new HashMap<>();
        this.textFields = new HashMap<>();
    }

    protected void showStage() {
        this.window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(type.toString());
        window.setMinWidth(250);
        VBox layout = new VBox(16);
        layout.setPadding(new Insets(20));

        this.saveButton = new Button("Save");
        this.cancelButton = new Button("Cancel");

        saveButton.setOnAction(e -> this.saveAction());
        cancelButton.setOnAction(e -> this.cancelAction());

        for (String fieldName : this.fields) {
            VBox field = new VBox(4);
            this.textFields.put(fieldName, new TextField());
            Label label = new Label(fieldName);
            field.getChildren().addAll(label, this.textFields.get(fieldName));
            layout.getChildren().addAll(field);
        }

        HBox buttons = new HBox(4);
        buttons.getChildren().addAll(saveButton, cancelButton);

        layout.getChildren().addAll(buttons);
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }

    private void saveAction() {
        textFields.forEach((fieldName, field) -> {
            String input = field.getText();
            if (!input.equals("")) {
                properties.put(fieldName, input);
            }
        });
        window.close();
    }

    private void cancelAction() {
        window.close();
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

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    protected void getDataFromDatabase() {
        HashMap<String, Object> shapeData = this.shapeDatabase.getShapeData(this.id);
        this.properties = this.propertyStringToMap((String) shapeData.get("properties"));
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
}
