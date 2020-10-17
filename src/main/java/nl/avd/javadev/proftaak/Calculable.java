package nl.avd.javadev.proftaak;

import java.util.List;

public interface Calculable {

    List<String> getFields();
    double getVolume();
    double calculateVolume();

}
