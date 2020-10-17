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
    public void getVolume() {

    }

    @Override
    public double calculateVolume() {
        int length = 10;
        int width = 5;
        int height = 3;
        double volume = length * width * height;
        throw new UnsupportedOperationException();
    }
}
