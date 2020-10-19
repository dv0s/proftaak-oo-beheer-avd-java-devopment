package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.InputMismatchException;

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
    public double getVolume() throws NumberFormatException, InputMismatchException {
        if (this.getProperty("length") < 0){
            throw new InputMismatchException("Length cannot be negative");
        }
        if (this.getProperty("width") < 0){
            throw new InputMismatchException("Width cannot be negative");
        }
        if (this.getProperty("height") < 0){
            throw new InputMismatchException("Height cannot be negative");
        }

        return (this.getProperty("length") * this.getProperty("width") * this.getProperty("height")) / 3.0;
    }

    @Override
    public void calculateVolume() {

    }
}
