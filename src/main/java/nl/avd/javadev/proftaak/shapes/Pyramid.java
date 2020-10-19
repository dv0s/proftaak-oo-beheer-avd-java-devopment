package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

public class Pyramid  extends Shape implements Calculable {

    public Pyramid(Integer id) {
        super();
        this.type = ShapeType.PYRAMID;
        this.fields = new String[]{"length", "width", "height"};
        this.id = id;
        if (id != null) {
            this.getDataFromDatabase();
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
