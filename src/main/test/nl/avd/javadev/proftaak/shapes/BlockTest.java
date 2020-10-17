package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    @Test
    void getVolume() {
        Map<String, String> properties = new HashMap<>();
        properties.put("length", "10.0");
        properties.put("width", "10.0");
        properties.put("height", "10.0");

        Block shape = new Block(properties);

        assertEquals(1000.0, shape.getVolume());
    }

//    @Test
//    void calculateVolume() {
//        Map<String, String> properties = new HashMap<>();
//        properties.put("length", "10.0");
//        properties.put("width", "10.0");
//        properties.put("height", "10.0");
//
//        Block shape = new Block(properties);
//
//        assertEquals(1000, shape.getVolume());
//
//    }
}