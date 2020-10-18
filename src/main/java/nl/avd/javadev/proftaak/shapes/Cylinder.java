package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Cylinder extends Shape implements Calculable {

    public Cylinder(Integer id) {
        super();
        this.type = ShapeType.CYLINDER;
        this.fields = new String[]{"radius", "height"};
        this.id = id;
        if (id != null) {
            this.setProperties();
        } else {
            this.showStage();
        }
    }

    @Override
    public double getVolume() {
        return 0.0;
    }

    @Override
    public void calculateVolume() {

    }
}
