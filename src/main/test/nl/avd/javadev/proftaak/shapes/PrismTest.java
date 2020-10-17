package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrismTest {

    @Test
    void calculateVolume() {
        Prism prism = new Prism(3,3,3);

        assertEquals(13.5, prism.calculateVolume());
    }
}