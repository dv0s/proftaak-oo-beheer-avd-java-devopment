package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Shape;
import nl.avd.javadev.proftaak.ShapeType;
import nl.avd.javadev.proftaak.Calculable;

import java.util.InputMismatchException;

public class Prism  extends Shape implements Calculable {

    public Prism(Integer id) {
        super();
        this.type = ShapeType.PRISM;
        this.fields = new String[]{"triangleBase", "triangleHeight", "prismHeight"};
        this.id = id;
        if (id != null) {
            this.getDataFromDatabase();
        }
    }

    @Override
    public double getVolume() throws NumberFormatException, InputMismatchException {
        if (this.getProperty("triangleBase") < 0){
            throw new InputMismatchException("triangle base cannot be negative");
        }
        if (this.getProperty("triangleHeight") < 0){
            throw new InputMismatchException("Triangle height cannot be negative");
        }
        if (this.getProperty("prismHeight") < 0){
            throw new InputMismatchException("Prism height cannot be negative");
        }

        return ((0.5) * (this.getProperty("triangleBase") * this.getProperty("triangleHeight"))) * this.getProperty("prismHeight");
    }

    @Override
    public void calculateVolume() {

    }
}
