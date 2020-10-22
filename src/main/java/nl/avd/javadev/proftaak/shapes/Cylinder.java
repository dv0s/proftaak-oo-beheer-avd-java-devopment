package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.InputMismatchException;

public class Cylinder extends Shape implements Calculable {

    public Cylinder(Integer id) {
        super();
        this.type = ShapeType.CYLINDER;
        this.fields = new String[]{"radius", "height"};
        this.id = id;
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public double getVolume() throws NumberFormatException, InputMismatchException{
        if (this.getProperty("radius") < 0){
            throw new InputMismatchException("Radius cannot be lower than 0");
        }
        if (this.getProperty("height") < 0){
            throw new InputMismatchException("Height cannot be lower than 0");
        }
        return Math.PI * (this.getProperty("radius")*this.getProperty("radius")) * this.getProperty("height");
    }

}
