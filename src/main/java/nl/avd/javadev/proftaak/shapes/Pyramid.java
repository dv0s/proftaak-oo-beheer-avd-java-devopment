package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Pyramid  extends Shape implements Calculable {

    public Pyramid(Map<String, String> properties) {
        super();
        this.type = ShapeType.PYRAMID;
        this.fields = new String[]{"length", "width", "height"};
        this.setProperties(properties);
    }

    @Override
    public double getVolume() {
        return 0.0;
    }

    @Override
    public void calculateVolume() {

    }
}
