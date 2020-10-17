package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Cone extends Shape implements Calculable {

    public Cone(Map<String, String> properties) {
        super();
        this.type = ShapeType.CONE;
        this.fields = new String[]{"radius", "height"};
        this.setProperties(properties);
    }

    @Override
    public double getVolume() {
        return this.getProperty("volume");
    }

    @Override
    public void calculateVolume() {
        double volume = Math.PI * (this.getProperty("radius") * this.getProperty("radius")) * (this.getProperty("height") / 3.0);
        this.setProperty("volume", "" + volume);
    }
}
