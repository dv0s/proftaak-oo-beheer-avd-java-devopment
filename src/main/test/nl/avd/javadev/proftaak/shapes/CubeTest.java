package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class CubeTest {

    @Test
    @DisplayName("Return 1000 when values are 10, 10 and 10")
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

    @Test
    void getVolume_forNegativeValues_returnException(){
        // Arrange

        // Act

        // Assert
        assertThrows(InputMismatchException.class, () -> {
            Map<String, String> properties = new HashMap<>();
            properties.put("length" , "-10");
            properties.put("width" , "-10");
            properties.put("height" , "-10");

            Cube cube = new Cube(null);

            cube.setProperties(properties);
            cube.getVolume();
        });

    }

    @Test
    @DisplayName("Throw exception when a String has been given.")
    void getVolume_throwsExceptionOn() {
        // Arrange
        // Act
        // Assert
        assertThrows(NumberFormatException.class, () -> {
            Map<String, String> properties = new HashMap<>();
            properties.put("length" , "10");
            properties.put("width" , "andere tekst");
            properties.put("height" , "pannekoek");

            Cube cube = new Cube(null);

            cube.setProperties(properties);
            cube.getVolume();
        });
    }
}