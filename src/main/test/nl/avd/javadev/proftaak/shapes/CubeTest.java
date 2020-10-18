package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class CubeTest {

    @Test
    void getVolume_for10and10and10_expect1000() {
        // Arrange
        Map<String, String> properties = new HashMap<>();
        properties.put("length" , "10");
        properties.put("width" , "10");
        properties.put("height" , "10");

        Cube cube = new Cube(null);

        cube.setProperties(properties);

        // Act
        double actual = cube.getVolume();

        // Assert
        assertEquals(1000, actual);
    }

//    @Test
//    void getVolume_throwsExceptionOn() {
//        // Arrange
//        Map<String, String> properties = new HashMap<>();
//        properties.put("length" , "10");
//        properties.put("width" , "andere tekst");
//        properties.put("height" , "pannekoek");
//
//        Cube cube = new Cube(null);
//
//        cube.setProperties(properties);
//
//        // Act
//        double actual = cube.getVolume();
//
//        // Assert
//        assertThrows(NumberFormatException.class, cube.getVolume());
//    }

    @Test
    void calculateVolume() {
    }
}