package nl.avd.javadev.proftaak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shape implements Initializable {

    public ShapeType shapeType;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(shapeType);
        try {
            App.setRoot("shapes/" + shapeType.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveShape(ActionEvent event) {
        System.out.println("TODO: Save input to database");
    }

    @FXML
    private void discardChanges(ActionEvent event) throws IOException {
        System.out.println("TODO: Load data from text file");
        App.setRoot("dashboard");
    }

    @Override
    public String toString() {
        return "Feest ik ben een: " + shapeType.toString();
    }
}
