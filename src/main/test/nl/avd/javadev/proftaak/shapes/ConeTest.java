package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConeTest {

    @Test
    @DisplayName("Return 1047.2 when values are 10 and 10")
    void getVolume_for10and10_expect1000() {
        // Arrange
        Map<String, String> properties = new HashMap<>();
        properties.put("radius" , "10");
        properties.put("height" , "10");

        Cone cone = new Cone(null);

        cone.setProperties(properties);

        // Act
        double actual = cone.getVolume();

        // Assert
        assertEquals(1047.2, actual, 0.1);
    }

    @Test
    @DisplayName("Return NumberFormatException when values are garbage")
    void getVolume_forGarbage_returnGarbage() {
        // Arrange

        // Assert
        assertThrows(NumberFormatException.class, () -> {
            Map<String, String> properties = new HashMap<>();
            properties.put("radius" , "10");
            properties.put("height" , "pannekoek");

            Cone cone = new Cone(null);

            cone.setProperties(properties);

            // Act
            double actual = cone.getVolume();
        });
    }

    @Test
    @DisplayName("Don't allow negative values")
    void getVolume_forNegativeValues_returnException(){
        // Arrange

        // Act

        // Assert
        assertThrows(InputMismatchException.class, () -> {
            Map<String, String> properties = new HashMap<>();
            properties.put("radius" , "-10");
            properties.put("height" , "-10");

            Cone cone = new Cone(null);

            cone.setProperties(properties);
            cone.getVolume();
        });

    }
}