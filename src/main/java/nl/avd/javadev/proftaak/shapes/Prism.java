package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.Map;

public class Prism  extends Shape implements Calculable {

    public Prism(Integer id) {
        super();
        this.type = ShapeType.PRISM;
        this.fields = new String[]{"length", "height"};
        this.id = id;
        if (id != null) {
            this.getDataFromDatabase();
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
