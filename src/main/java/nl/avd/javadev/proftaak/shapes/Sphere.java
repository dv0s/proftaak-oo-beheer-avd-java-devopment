package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;
import java.util.InputMismatchException;

public class Sphere  extends Shape implements Calculable {

    public Sphere(Integer id) {
        super();
        this.type = ShapeType.SPHERE;
        this.fields = new String[]{"radius"};
        this.id = id;
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public double getVolume() throws NumberFormatException, InputMismatchException {
        if (this.getProperty("radius") < 0){
            throw new InputMismatchException("Radius cannot be negative");
        }
        return (4.0 / 3.0) * Math.PI * (this.getProperty("radius")*this.getProperty("radius")*this.getProperty("radius"));
    }

}
