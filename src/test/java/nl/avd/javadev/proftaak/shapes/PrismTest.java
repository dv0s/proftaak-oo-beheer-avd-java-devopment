package nl.avd.javadev.proftaak.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrismTest {
    private static Map<String, String> properties;
    private static Prism sut;

    @BeforeAll
    static void beforeAll(){
        properties = new HashMap<>();
        sut = new Prism(null);
    }

    @Test
    @DisplayName("Return 70 when values are 4 and 5 for the triangle, and 7 for the height of the Prism")
    void getVolume_for10and10_expect1000() {
        // Arrange
        properties.put("triangleBase" , "4");
        properties.put("triangleHeight" , "5");
        properties.put("prismHeight", "7");
        sut.setProperties(properties);

        // Act
        double actual = sut.getVolume();

        // Assert
        assertEquals(70.00, actual, 0.01);
    }

    @Test
    @DisplayName("Return NumberFormatException when values are garbage")
    void getVolume_forGarbage_returnGarbage() {
        // Arrange
        properties.put("triangleBase" , "4");
        properties.put("triangleHeight" , "pannekoek");
        properties.put("prismHeight", "7");
        sut.setProperties(properties);

        // Act

        // Assert
        assertThrows(NumberFormatException.class, () -> {
            sut.getVolume();
        });
    }

    @Test
    @DisplayName("Don't allow negative values")
    void getVolume_forNegativeValues_returnException(){
        // Arrange
        properties.put("triangleBase" , "4");
        properties.put("triangleHeight" , "-5");
        properties.put("prismHeight", "7");
        sut.setProperties(properties);

        // Act

        // Assert
        assertThrows(InputMismatchException.class, () -> {
            sut.getVolume();
        });

    }
}