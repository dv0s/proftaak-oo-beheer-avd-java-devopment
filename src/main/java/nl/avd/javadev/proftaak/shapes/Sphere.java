package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.CalculableShape;
import java.util.InputMismatchException;

public class Sphere  extends Shape implements CalculableShape {

    public Sphere(Integer id) {
        super();
        this.setType(ShapeType.SPHERE);
        this.setFields(new String[]{"radius"});
        this.setId(id);
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public Double getVolume() throws NumberFormatException, InputMismatchException {
        if (this.getProperty("radius") < 0){
            throw new InputMismatchException("Radius cannot be negative");
        }
        return (4.0 / 3.0) * Math.PI * (this.getProperty("radius")*this.getProperty("radius")*this.getProperty("radius"));
    }

}
