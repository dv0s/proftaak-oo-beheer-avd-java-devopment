package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.HashMap;
import java.util.Map;

public class Cone extends Shape implements Calculable {

    public Cone(Integer id) {
        super();
        this.type = ShapeType.CONE;
        this.fields = new String[]{"radius", "height"};
        this.id = id;
        if (id != null) {
            Map<String, String> tmpProperties = new HashMap<>();
            tmpProperties.put("radius", "3");
            tmpProperties.put("height", "5");
            this.setProperties(tmpProperties);
        } else {
            this.showStage();
        }
    }

    @Override
    public double getVolume() {
        return (1.0/3) * Math.PI  * this.getProperty("radius") * this.getProperty("radius") * this.getProperty("height");
    }

    @Override
    public void calculateVolume() {

    }


}
