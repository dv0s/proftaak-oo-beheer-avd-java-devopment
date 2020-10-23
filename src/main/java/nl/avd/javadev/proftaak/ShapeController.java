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
import java.util.HashMap;
import java.util.Map;

public class ShapeController {

    private Button saveButton;
    private Button cancelButton;
    private Stage window;
    protected String[] fields;
    private String title;
    private Map<String, TextField> textFields = new HashMap<>();
    private Map<String, String> properties =  new HashMap<>();

    public ShapeController(String title, String[] fields) {
        this.title = title;
        this.fields = fields;
        this.showStage();
    }

    private void showStage() {
        this.window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(this.title);
        window.setMinWidth(250);
        VBox layout = new VBox(16);
        layout.setPadding(new Insets(20));

        this.setButtons();

        for (String fieldName : this.fields) {
            VBox field = new VBox(4);
            this.textFields.put(fieldName, new TextField());
            Label label = new Label(fieldName);
            field.getChildren().addAll(label, this.textFields.get(fieldName));
            layout.getChildren().addAll(field);
        }

        HBox buttons = new HBox(4);
        buttons.getChildren().addAll(this.saveButton, this.cancelButton);

        layout.getChildren().addAll(buttons);
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }

    private void setButtons() {
        this.saveButton = new Button("Save");
        this.cancelButton = new Button("Cancel");
        this.saveButton.setOnAction(e -> this.saveAction());
        this.cancelButton.setOnAction(e -> this.cancelAction());
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

    public Map<String, String> getShapeProperties() {
        return this.properties;
    }
}
