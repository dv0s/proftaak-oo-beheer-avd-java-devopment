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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shape {

    private Stage window = new Stage();
    protected ShapeType type;
    protected List<String> fields = new ArrayList<>();
    private Map<String, String> properties;
    private Map<String, TextField> textFields = new HashMap<>();
    private Button saveButton = new Button("Save");
    private Button cancelButton = new Button("Cancel");

    protected void setProperties(Map<String, String> properties) {
        if (properties == null) {
            this.properties = new HashMap<>();
            this.showStage();
        } else {
            this.properties = properties;
        }
    }

    protected void showStage() {
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(type.toString());
        window.setMinWidth(250);
        VBox layout = new VBox(16);
        layout.setPadding(new Insets(20));
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
        String fieldSting = this.getFieldSting();
        return this.type + " - " + fieldSting;
    }

    public String getType() {
        return this.type.toString();

    }

    public Double getProperty(String key) {
        return Double.parseDouble(this.properties.get(key));
    }

    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public String getFieldSting(){
        return this.fields.stream()
                .collect(Collectors.joining(",", "", ""));
    }

    // TODO: Remove this later?
//    public String getFieldSting() {
//        return this.fields.keySet().stream()
//                .map(key -> key + ": " + this.properties.get(key))
//                .collect(Collectors.joining(", ", "", ""));
//    }
}
