package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Calculable;
import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;

import java.util.Map;

public class Block extends Shape implements Calculable {

    public Block(Map<String, String> properties) {
        super();
        this.type = ShapeType.SPHERE;
        this.fields = new String[]{"radius"};
        this.setProperties(properties);
    }

    @Override
    public double getVolume() {
        return this.getProperty("volume");
    }

    public void calculateVolume() {
        double volume = this.getProperty("length") * this.getProperty("width") * this.getProperty("height");
        this.setProperty("volume", "" + volume);
    }
}
