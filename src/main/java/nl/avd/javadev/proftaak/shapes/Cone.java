package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;
import java.util.InputMismatchException;

public class Cone extends Shape implements Calculable {

    public Cone(Integer id) {
        super();
        this.setType(ShapeType.CONE);
        this.setFields(new String[]{"radius", "height"});
        this.setId(id);
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public Double getVolume() {
        if (this.getProperty("radius") < 0){
            throw new InputMismatchException("Input for radius cannot be negative");
        }

        if (this.getProperty("height") < 0){
            throw new InputMismatchException("Input for height cannot be negative");
        }

        return (1.0/3) * Math.PI  * this.getProperty("radius") * this.getProperty("radius") * this.getProperty("height");
    }

}
