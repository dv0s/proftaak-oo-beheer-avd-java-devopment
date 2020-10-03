package nl.avd.javadev.proftaak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shape implements Initializable {

    public ShapeType shapeType;
    private Scene scene;
    private Stage stage;

    public Shape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public void openScene() throws IOException {
        Object fxml = App.loadFXML("shapes/" + shapeType.toString().toLowerCase());
        this.scene = new Scene((Parent) fxml);
        this.stage = new Stage();
        stage.setScene(this.scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(shapeType);
    }

    @FXML
    private void saveShape(ActionEvent event) {
        System.out.println("TODO: Save input to database");
        this.closeWindow(event);
    }

    @FXML
    private void discardChanges(ActionEvent event) throws IOException {
        System.out.println("TODO: Load data from text file");
        this.closeWindow(event);
    }

    protected void closeWindow(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public String toString() {
        return "Feest, ik ben een: " + shapeType.toString();
    }
}
