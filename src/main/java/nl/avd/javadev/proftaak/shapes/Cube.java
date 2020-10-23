package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.InputMismatchException;

public class Cube extends Shape implements Calculable {

    public Cube(Integer id) {
        super();
        this.setType(ShapeType.CUBE);
        this.setFields(new String[]{"length", "width", "height"});
        this.setId(id);
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public Double getVolume() throws NumberFormatException, InputMismatchException {
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

}
