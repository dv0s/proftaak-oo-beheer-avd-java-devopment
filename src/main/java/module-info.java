module nl.avd.javadev.proftaak {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens nl.avd.javadev.proftaak to javafx.fxml;
    opens nl.avd.javadev.proftaak.shapes to javafx.fxml;
    exports nl.avd.javadev.proftaak;
}