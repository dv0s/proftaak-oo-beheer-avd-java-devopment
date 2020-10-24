package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.CalculableShape;
import java.util.InputMismatchException;

public class Cylinder extends Shape implements CalculableShape {

    public Cylinder(Integer id) {
        super();
        this.setType(ShapeType.CYLINDER);
        this.setFields(new String[]{"radius", "height"});
        this.setId(id);
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public Double getVolume() throws NumberFormatException, InputMismatchException{
        if (this.getProperty("radius") < 0){
            throw new InputMismatchException("Radius cannot be lower than 0");
        }
        if (this.getProperty("height") < 0){
            throw new InputMismatchException("Height cannot be lower than 0");
        }
        return Math.PI * (this.getProperty("radius")*this.getProperty("radius")) * this.getProperty("height");
    }

}
