package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SphereTest {
    private static Map<String, String> properties;
    private static Sphere sut;

    @BeforeAll
    static void beforeAll() {
        properties = new HashMap<>();
        sut = new Sphere(null);
    }

    @Test
    @DisplayName("Return 9.2 when values is 1.3 for radius of the Sphere")
    void getVolume_for10and10_expect1000() {
        // Arrange
        properties.put("radius", "1.3");
        sut.setProperties(properties);

        // Act
        double actual = sut.getVolume();

        // Assert
        assertEquals(9.2, actual, 0.1);
    }

    @Test
    @DisplayName("Return NumberFormatException when values are garbage")
    void getVolume_forGarbage_returnGarbage() {
        // Arrange
        properties.put("radius", "pannekoek");
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
        properties.put("radius", "-1.3");
        sut.setProperties(properties);

        // Act

        // Assert
        assertThrows(InputMismatchException.class, () -> {
            sut.getVolume();
        });

    }
}