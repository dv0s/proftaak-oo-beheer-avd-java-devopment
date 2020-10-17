package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Prism  extends Shape implements Calculable {

    public Prism(Map<String, String> properties) {
        super();
        this.type = ShapeType.PRISM;
        this.fields = new String[]{"length", "height"};
        this.setProperties(properties);
    }

    @Override
    public void getVolume() {

    }

    @Override
    public void calculateVolume() {

    }
}
