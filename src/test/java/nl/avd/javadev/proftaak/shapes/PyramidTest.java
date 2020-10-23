package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PyramidTest {
    private static Map<String, String> properties;
    private static Pyramid sut;

    @BeforeAll
    static void beforeAll() {
        properties = new HashMap<>();
        sut = new Pyramid(null);
    }

    @Test
    @DisplayName("Return 14 when values are 2 for length, 3 for width and 7 for the height of the Pyramid")
    void getVolume_for10and10_expect1000() {
        // Arrange
        properties.put("length", "2");
        properties.put("width", "3");
        properties.put("height", "7");
        sut.setProperties(properties);

        // Act
        double actual = sut.getVolume();

        // Assert
        assertEquals(14.00, actual, 0.01);
    }

    @Test
    @DisplayName("Return NumberFormatException when values are garbage")
    void getVolume_forGarbage_returnGarbage() {
        // Arrange
        properties.put("length", "2");
        properties.put("width", "pannekoek");
        properties.put("height", "7");
        sut.setProperties(properties);

        // Act

        // Assert
        assertThrows(NumberFormatException.class, () -> {
            sut.getVolume();
        });
    }

    @Test
    @DisplayName("Don't allow negative values")
    void getVolume_forNegativeValues_returnException() {
        // Arrange
        properties.put("length", "2");
        properties.put("width", "-3");
        properties.put("height", "7");
        sut.setProperties(properties);

        // Act

        // Assert
        assertThrows(InputMismatchException.class, () -> {
            sut.getVolume();
        });

    }
}