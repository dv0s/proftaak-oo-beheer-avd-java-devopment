package nl.avd.javadev.proftaak.shapes;

import nl.avd.javadev.proftaak.Calculable;

public class Block implements Calculable {

    @Override
    public void getVolume() {

    }

    @Override
    public double calculateVolume() {
        int length = 10;
        int width = 5;
        int height = 3;
        double volume = length * width * height;
        throw new UnsupportedOperationException();
    }
}
