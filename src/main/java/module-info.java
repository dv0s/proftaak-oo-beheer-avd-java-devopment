module nl.avd.javadev.proftaak {
    requires javafx.controls;
    requires javafx.fxml;

    opens nl.avd.javadev.proftaak to javafx.fxml;
    exports nl.avd.javadev.proftaak;
}