package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.InputMismatchException;
import java.util.Map;

public class Cube extends Shape implements Calculable {

    public Cube(Integer id) {
        super();
        this.type = ShapeType.CUBE;
        this.fields = new String[]{"length", "width", "height"};
        this.id = id;
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public double getVolume() throws NumberFormatException, InputMismatchException {
        if (this.getProperty("length") < 0){
            throw new InputMismatchException("Length cannot be lower than 0");
        }
        if (this.getProperty("width") < 0){
            throw new InputMismatchException("Width cannot be lower than 0");
        }
        if (this.getProperty("height") < 0){
            throw new InputMismatchException("Height cannot be lower than 0");
        }
        return this.getProperty("length") * this.getProperty("width") * this.getProperty("height");
    }

    @Override
    public void calculateVolume() {

    }

}
